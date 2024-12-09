package com.example.imdmarketkotlin

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
            val intent = Intent(this, InicialActivity::class.java)

            //Alterando os dados do produto
            if (codigoTemp.isNotBlank()){
                val produtoTemp = listaProdutos.find { it.codigoProduto == codigoTemp }
                if (listaProdutos.contains(produtoTemp)){
                    if (nomeTemp.isNotEmpty()){
                        produtoTemp?.setNome(nomeTemp)
                    }
                    if (descTemp.isNotEmpty()){
                        produtoTemp?.setDesc(descTemp)
                    }
                    if (estoqueTemp.isNotEmpty()){
                        produtoTemp?.estoque = estoqueTemp.toInt()
                    }
                }else{
                    Toast.makeText(this, "Produto nao encontrado!", Toast.LENGTH_LONG).show()
                    startActivity(intent)
                }
                Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_LONG).show()
                intent.putParcelableArrayListExtra("produtos", ArrayList(listaProdutos))
                startActivity(intent)

            }else{
                Toast.makeText(this, "Informe um codigo!", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }






        }

        //Botão para limpar os campos
        binding.btnLimpar.setOnClickListener{
            binding.edCodigo.text.clear()
            binding.edNome.text.clear()
            binding.edDesc.text.clear()
            binding.edEstoque.text.clear()
        }
    }

    //Salvando arquivo ao fechar o programa/activity
    override fun onDestroy() {
        super.onDestroy()
        val fileManip = FileManip()
        fileManip.saveListaProdutos(this, listaProdutos)


    }
}

