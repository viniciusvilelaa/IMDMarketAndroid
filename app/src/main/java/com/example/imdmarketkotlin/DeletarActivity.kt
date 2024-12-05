package com.example.imdmarketkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityDeletarBinding

class DeletarActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDeletarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeletarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val i = Intent(this, InicialActivity::class.java)

        binding.btnDeletar.setOnClickListener{
            startActivity(i)
        }

    }


}