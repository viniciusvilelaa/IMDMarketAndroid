package com.example.imdmarketkotlin
import Produto
import kotlinx.serialization.decodeFromString

import android.content.Context
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File

//Classe FileManip para realizar a manipulação dos arquivos
class FileManip  {

    //Salva o arquivo com a lista de produtos
    @OptIn(ExperimentalSerializationApi::class)
    fun saveListaProdutos(context: Context, listaProdutos: MutableList<Produto>, fileName: String = "produtos.json") {
        val jsonString = Json.encodeToString(listaProdutos)
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use { outPutStream -> outPutStream.write(jsonString.toByteArray()) }

    }

    //Carrega o arquivo
    @OptIn(ExperimentalSerializationApi::class)
    fun loadListaProdutos(context: Context, fileName: String = "produtos.json") : MutableList<Produto>{
        return try{
            val jsonString = context.openFileInput(fileName).bufferedReader().use { it.readText() }
            Json.decodeFromString(jsonString)

        } catch (e: Exception){
            mutableListOf()
        }
    }

}