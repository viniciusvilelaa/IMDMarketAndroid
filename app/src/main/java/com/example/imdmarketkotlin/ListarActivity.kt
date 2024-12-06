package com.example.imdmarketkotlin

import Produto
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdmarketkotlin.databinding.ActivityListaBinding
import com.google.gson.Gson
import java.io.File

class ListarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaBinding

    //Recebendo a listaProdutos por intent
    val listaProdutos =  intent.getParcelableArrayListExtra<Produto>("produtos") ?: mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configurando o RecycleView e alimentando com a listaProdutos
        val recyclerView: RecyclerView = binding.rvProdutos
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProdutoAdapter(listaProdutos)
        recyclerView.adapter = adapter

        //Botão para voltar
        binding.btnVoltar.setOnClickListener {
            val i = Intent(this, InicialActivity::class.java)
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