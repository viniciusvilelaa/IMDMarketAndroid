package com.example.imdmarketkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityCadastroBinding


class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding


    //Instanciando a classe de manipulação de arquivos
    //val fileManip = FileManip()

    //Criando a lista de produtos
    private val listaProdutos = mutableListOf<Produto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recebendo lista de produtos por intent
        val produtosRecebidos = intent.getParcelableArrayListExtra<Produto>("produtos")?: mutableListOf<Produto>()
        listaProdutos.addAll(produtosRecebidos)

        //Carregando arquivo json com a lista de produtos
        //listaProdutos = fileManip.loadListaProdutos(this)

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
                    Toast.makeText(this, "Este produto já está cadastrado", Toast.LENGTH_LONG).show()

                }else{
                    println(listaProdutos)
                    listaProdutos.add(produtoTemp)

                    //Enviando listaProdutos por intent para a tela inicial
                    var intent = Intent(this, InicialActivity::class.java)
                    intent.putParcelableArrayListExtra("produtos", ArrayList(listaProdutos))
                    Toast.makeText(this, "{$listaProdutos}!", Toast.LENGTH_LONG).show()
                    println(listaProdutos)
                    startActivity(intent)



                }

            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
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