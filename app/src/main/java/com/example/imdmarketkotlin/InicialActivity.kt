package com.example.imdmarketkotlin

import Produto
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityInicialBinding
import com.example.imdmarketkotlin.databinding.ActivityListaBinding
import com.google.gson.Gson
import java.util.ArrayList


class InicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicialBinding


    //private val listaProdutos = mutableListOf<Produto>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val produtosRecebidos = intent.getParcelableArrayListExtra<Produto>("produtos")?: mutableListOf<Produto>()
        //listaProdutos.addAll(produtosRecebidos)

        //Chamada para tela de cadastro
        binding.btnCadastrar.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", ArrayList(produtosRecebidos))
            println(produtosRecebidos)
            startActivity(intent)
        }

        //Chamada para tela de alteração
        binding.btnAlterar.setOnClickListener{
            val intent = Intent(this, AlterarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", ArrayList(produtosRecebidos))
            startActivity(intent)
        }

        //Chamada para tela de listagem
        binding.btnListar.setOnClickListener {

            val intent = Intent(this, ListarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", ArrayList(produtosRecebidos))
            println(produtosRecebidos)
            startActivity(intent)
        }

        //Chamada para tela de delete
        binding.btnDeletar.setOnClickListener {
            val intent = Intent(this, DeletarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", ArrayList(produtosRecebidos))
            println(produtosRecebidos)
            startActivity(intent)
        }

    }

    //Salvando arquivo ao fechar o programa/activity
   /* override fun onDestroy() {
        super.onDestroy()
        val listaProdutos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: arrayListOf()
        val fileManip = FileManip()
        fileManip.saveListaProdutos(this, listaProdutos)

    }*/
}