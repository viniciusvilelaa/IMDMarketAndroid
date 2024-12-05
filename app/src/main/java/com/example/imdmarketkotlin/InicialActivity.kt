package com.example.imdmarketkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityInicialBinding
import com.example.imdmarketkotlin.databinding.ActivityListaBinding


class InicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicialBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener{
            val i = Intent(this, CadastroActivity::class.java)
            startActivity(i)
        }

        binding.btnAlterar.setOnClickListener{
            val i = Intent(this, AlterarActivity::class.java)
            startActivity(i)
        }

        binding.btnListar.setOnClickListener {
            val produtos = intent.getParcelableArrayListExtra<Produto>("produtos") ?: arrayListOf()
            val intent = Intent(this, ListarActivity::class.java)
            intent.putParcelableArrayListExtra("produtos", produtos)

            startActivity(intent)
        }

        binding.btnDeletar.setOnClickListener {
            val i = Intent(this, DeletarActivity::class.java)
            startActivity(i)
        }





    }


}