package com.example.imdmarketkotlin

import Produto
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityInicialBinding
import com.example.imdmarketkotlin.databinding.ActivityListaBinding


class InicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicialBinding
    val listaProdutos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener{

            val i = Intent(this, CadastroActivity::class.java)
            startActivity(i)
        }

        binding.btnAlterar.setOnClickListener{
            val intent = Intent(this, AlterarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", listaProdutos)
            startActivity(intent)
        }

        binding.btnListar.setOnClickListener {

            val intent = Intent(this, ListarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", listaProdutos)
            startActivity(intent)
        }

        binding.btnDeletar.setOnClickListener {
            val intent = Intent(this, DeletarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", listaProdutos)
            startActivity(intent)
        }





    }

    override fun onDestroy() {
        super.onDestroy()
        val fileManip = FileManip()
        fileManip.saveListaProdutos(this, listaProdutos)


    }
}