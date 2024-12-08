package com.example.imdmarketkotlin

import Produto
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityDeletarBinding

class DeletarActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDeletarBinding

    //Recebendo a listaProdutos por intent
    private val listaProdutos = mutableListOf<Produto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeletarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var produtosRecebidos = intent.getParcelableArrayListExtra<Produto>("produtos")?:mutableListOf<Produto>()
        listaProdutos.addAll(produtosRecebidos)

        val i = Intent(this, InicialActivity::class.java)

        //Deletando o produto
        binding.btnDeletar.setOnClickListener{
            val codigoTemp = binding.edCodigo2.text.toString()
            val produtoTemp = listaProdutos.find { it.codigoProduto == codigoTemp }

            //Verifica se existe o produto com o codigo informado, se existir, produto é excluido
            if (produtoTemp != null){
                listaProdutos.remove(produtoTemp)
                Toast.makeText(this, "Produto excluido", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Nenhum produto encontrado com o codigo informado", Toast.LENGTH_LONG).show()
            }
            //Enviando listaProdutos por intent para a tela inicial
            i.putParcelableArrayListExtra("produtos", ArrayList(listaProdutos))
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