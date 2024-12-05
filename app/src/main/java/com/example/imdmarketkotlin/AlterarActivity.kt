package com.example.imdmarketkotlin

import Produto
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityAlterarBinding
import kotlin.text.clear

class AlterarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlterarBinding
    var listaProdutos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlterarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = Intent(this, InicialActivity::class.java)

        binding.btnSalvar.setOnClickListener{
            startActivity(i)
        }

        binding.btnLimpar.setOnClickListener{
            var codigoTemp = binding.edCodigo.text.clear()
            var nomeTemp = binding.edNome.text.clear()
            var descTemp = binding.edDesc.text.clear()
            var estoqueTemp = binding.edEstoque.text.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val fileManip = FileManip()
        fileManip.saveListaProdutos(this, listaProdutos)


    }
}

