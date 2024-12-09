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

        //Salvando o login com SharedPreferences
        val sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val prefLogin = sharedPreferences.getString("LOGIN","")
        val prefSenha =  sharedPreferences.getString("SENHA", "")

        //Bind dos editText
        val login = binding.edName
        val senha = binding.edSenha

        //Verifica se tem senha salva na SharedPreferences, caso esteja salva, preenche
        // os valores com a senha salva
        if (prefLogin != null && prefSenha != null){
            login.setText(prefLogin)
            senha.setText(prefSenha)
        }

        //Algoritimo de login
        binding.btnEntrar.setOnClickListener{
            val veriLogin = binding.edName.text.toString()
            val veriSenha = binding.edSenha.text.toString()

            //Verifica se os campos de Login e Senha estão preenchidos
            if (veriLogin.isNotEmpty() && veriSenha.isNotEmpty() ){

                //Verifica se o login e senha informados são "admin" e "admin"
                if (veriLogin == ("admin") && veriSenha == ("admin")){
                    editor.putString("LOGIN", veriLogin)
                    editor.putString("SENHA", veriSenha)
                    editor.apply()
                    val i = Intent(this, InicialActivity::class.java)
                    //i.putParcelableArrayListExtra("produtos", ArrayList(listaProdutos))
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

