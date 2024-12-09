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

    private var arquivoLista = mutableListOf<Produto>()
    val fileManip = FileManip()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arquivoLista = fileManip.loadListaProdutos(this,"produtos.json")

        //Recebendo lista de produtos por intent
        val produtosRecebidos = intent.getParcelableArrayListExtra<Produto>("produtos")?: mutableListOf<Produto>()
        produtosRecebidos.addAll(arquivoLista)

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
    override fun onDestroy() {
        super.onDestroy()
        val listaProdutos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: mutableListOf<Produto>()
        fileManip.saveListaProdutos(this, listaProdutos)

    }
}