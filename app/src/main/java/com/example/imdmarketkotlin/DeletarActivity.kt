package com.example.imdmarketkotlin

import Produto
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityDeletarBinding

class DeletarActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDeletarBinding

    //Recebendo a listaProdutos por intent
     var listaProdutos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeletarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val i = Intent(this, InicialActivity::class.java)

        binding.btnDeletar.setOnClickListener{
            startActivity(i)
        }

    }

    //Salvando arquivo ao fechar o programa/activity
    override fun onDestroy() {
        super.onDestroy()
        val fileManip = FileManip()
        fileManip.saveListaProdutos(this, listaProdutos)


    }

}