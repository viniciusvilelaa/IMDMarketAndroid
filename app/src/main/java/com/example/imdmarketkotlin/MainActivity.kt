package com.example.imdmarketkotlin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarketkotlin.databinding.ActivityMainBinding
import com.example.imdmarketkotlin.ui.theme.IMDMARKETKOTLINTheme

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val prefLogin = sharedPreferences.getString("LOGIN","")
        val prefSenha =  sharedPreferences.getString("SENHA", "")
        var login = binding.edName
        var senha = binding.edSenha

        if (prefLogin != null && prefSenha != null){
            login.setText(prefLogin)
            senha.setText(prefSenha)
        }

        binding.btnEntrar.setOnClickListener{
            var veriLogin = binding.edName.text.toString()
            var veriSenha = binding.edSenha.text.toString()


            if (veriLogin.isNotEmpty() && veriSenha.isNotEmpty() ){
                if (veriLogin == ("admin") && veriSenha == ("admin")){
                    editor.putString("LOGIN", veriLogin)
                    editor.putString("SENHA", veriSenha)
                    editor.apply()
                    val i = Intent(this, InicialActivity::class.java)
                    Toast.makeText(this, "Senha correta", Toast.LENGTH_LONG).show()
                    i.putExtra("nomeUsuario", veriLogin)
                    startActivity(i)


                } else{
                    Toast.makeText(this, "Usuário ou Senha incorretos!", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Preencha os campos de Usuário ou Senha!", Toast.LENGTH_LONG).show()
            }
        }

    }
}

