package com.example.imdmarketkotlin

import Produto
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityCadastroBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json
import java.io.File


class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding

    //Instanciando a classe de manipulação de arquivos
    val fileManip = FileManip()

    //Instanciando a lista
    var listaProdutos = mutableListOf<Produto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Carregando arquivo json com a lista de produtos
        listaProdutos = fileManip.loadListaProdutos(this)

        val i = Intent(this, InicialActivity::class.java)

        binding.btnSalvar.setOnClickListener {

            //Capturando valores dos EditText
            val codigoTemp = binding.edCodigo.text.toString()
            val nomeTemp = binding.edNome.text.toString()
            val descTemp = binding.edDesc.text.toString()
            val estoqueTemp = binding.edEstoque.text.toString()

            //Verificando se tem algum campo vazio
            if (codigoTemp.isNotEmpty() && nomeTemp.isNotEmpty() && descTemp.isNotEmpty() && estoqueTemp.isNotEmpty()){
                val produtoTemp = Produto(codigoTemp,nomeTemp,descTemp,estoqueTemp.toInt())
                //Verificando se ja existe o produto na lista
                if (listaProdutos.contains(produtoTemp)){
                    Toast.makeText(this, "Este produto ja existe no banco de dados", Toast.LENGTH_LONG).show()

                }else{
                    listaProdutos.add(produtoTemp)
                    i.putParcelableArrayListExtra("produtos", ArrayList(listaProdutos))
                    Toast.makeText(this, "Produto salvo!", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }

            startActivity(i)

        }

        //Botão para limpar os campos
        binding.btnLimpar.setOnClickListener{
            var codigoTemp = binding.edCodigo.text.clear()
            var nomeTemp = binding.edNome.text.clear()
            var descTemp = binding.edDesc.text.clear()
            var estoqueTemp = binding.edEstoque.text.clear()
        }

    }

    //Salvando arquivo ao fechar o programa/activity
    override fun onDestroy() {
        super.onDestroy()
        val fileManip = FileManip()
        fileManip.saveListaProdutos(this, listaProdutos)


    }




}