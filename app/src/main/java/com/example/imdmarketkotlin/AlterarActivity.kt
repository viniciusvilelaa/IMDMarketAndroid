package com.example.imdmarketkotlin

import Produto
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityAlterarBinding

class AlterarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlterarBinding

    private val listaProdutos = mutableListOf<Produto>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlterarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recebendo lista de produtos por intent
        val produtosRecebidos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: mutableListOf<Produto>()
        listaProdutos.addAll(produtosRecebidos)

        binding.btnSalvar.setOnClickListener{
            val codigoTemp = binding.edCodigo.text.toString()
            val nomeTemp = binding.edNome.text.toString()
            val descTemp = binding.edDesc.text.toString()
            val estoqueTemp = binding.edEstoque.text.toString()

            //Alterando os dados do produto
            if (codigoTemp.isNotEmpty()){
                val produtoTemp = listaProdutos.find { it.codigoProduto == codigoTemp }
                if (nomeTemp.isNotEmpty()){
                    produtoTemp?.setNome(nomeTemp)
                }
                if (descTemp.isNotEmpty()){
                    produtoTemp?.setDesc(descTemp)
                }
                if (estoqueTemp.isNotEmpty()){
                    produtoTemp?.estoque = estoqueTemp.toInt()
                }
            }

            Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_LONG).show()
            
            //Enviando listaProdutos por intent para a tela inicial
            val intent = Intent(this, InicialActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", ArrayList(listaProdutos))
            startActivity(intent)
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

