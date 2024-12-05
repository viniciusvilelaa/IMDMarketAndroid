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
    var fileManip = FileManip()
    var listaProdutos = mutableListOf<Produto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaProdutos = fileManip.loadListaProdutos(this)

        val i = Intent(this, InicialActivity::class.java)

        binding.btnSalvar.setOnClickListener {

            var codigoTemp = binding.edCodigo.text.toString()
            var nomeTemp = binding.edNome.text.toString()
            var descTemp = binding.edDesc.text.toString()
            var estoqueTemp = binding.edEstoque.text.toString()


            if (codigoTemp.isNotEmpty() && nomeTemp.isNotEmpty() && descTemp.isNotEmpty() && estoqueTemp.isNotEmpty()){
                listaProdutos.add(Produto(codigoTemp,nomeTemp,descTemp,estoqueTemp.toInt()))
                i.putParcelableArrayListExtra("produtos", ArrayList(listaProdutos))
                Toast.makeText(this, "Produto salvo!", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }

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