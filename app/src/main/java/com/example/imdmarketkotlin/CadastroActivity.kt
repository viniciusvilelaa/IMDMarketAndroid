package com.example.imdmarketkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityCadastroBinding


class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listaProdutos = mutableListOf<Produto>()

        binding.btnSalvar.setOnClickListener {

            var codigoTemp = binding.edCodigo.text.toString()
            var nomeTemp = binding.edNome.text.toString()
            var descTemp = binding.edDesc.text.toString()
            var estoqueTemp = binding.edEstoque.text.toString()


            if (codigoTemp.isNotEmpty() && nomeTemp.isNotEmpty() && descTemp.isNotEmpty() && estoqueTemp.isNotEmpty()){
                listaProdutos.add(Produto(codigoTemp,nomeTemp,descTemp,estoqueTemp.toInt()))
                Toast.makeText(this, "Produto salvo!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }



        }


    }

}