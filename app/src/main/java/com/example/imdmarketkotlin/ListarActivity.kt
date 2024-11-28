package com.example.imdmarketkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityListaBinding

class ListarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnVoltar.setOnClickListener {
            val i = Intent(this, InicialActivity::class.java)
            startActivity(i)
        }

    }

}