package com.example.imdmarketkotlin

import Produto
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityInicialBinding
import com.example.imdmarketkotlin.databinding.ActivityListaBinding


class InicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicialBinding

    //Recebendo a listaProdutos por intent
    private val listaProdutos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Chamada para tela de cadastro
        binding.btnCadastrar.setOnClickListener{

            val i = Intent(this, CadastroActivity::class.java)
            startActivity(i)
        }

        //Chamada para tela de alteração
        binding.btnAlterar.setOnClickListener{
            val intent = Intent(this, AlterarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", listaProdutos)
            startActivity(intent)
        }

        //Chamada para tela de listagem
        binding.btnListar.setOnClickListener {

            val intent = Intent(this, ListarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", listaProdutos)
            startActivity(intent)
        }

        //Chamada para tela de delete
        binding.btnDeletar.setOnClickListener {
            val intent = Intent(this, DeletarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", listaProdutos)
            startActivity(intent)
        }

    }

    //Salvando arquivo ao fechar o programa/activity
    override fun onDestroy() {
        super.onDestroy()
        val fileManip = FileManip()
        fileManip.saveListaProdutos(this, listaProdutos)

    }
}