package com.example.imdmarketkotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class ProductDb(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,  DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME = "dbproduct"
        private const val DATABASE_VERSION =  1
    }

    //Criando a table para os produtos
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            """
                    CREATE TABLE products(
                    codigo TEXT PRIMARY KEY,
                    nome TEXT,
                    descricao TEXT,
                    estoque INTEGER
                    
                    
                    )
                """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {


    }

    //Func para salvar produto no banco de dados
    fun saveProduct(codigo: String, nome: String, descricao: String, estoque: Int): Long{
        val db = this.writableDatabase
        val container = ContentValues()
        container.put("codigo", codigo)
        container.put("nome", nome)
        container.put("descricao", descricao)
        container.put("estoque", estoque)
        var result = db.insert("dbproduct", null, container)
        db.close()
        return result
    }

    //Func para alterar dados de um produto
    fun updateProduct(codigo: String, nome: String, descricao: String, estoque: Int): Int{
        val db = this.writableDatabase
        val container = ContentValues()
        if(nome.isNotBlank()){
            container.put("nome", nome)
        }
        if (descricao.isNotBlank()){
            container.put("descricao", descricao)
        }
        if (estoque.toString().isNotBlank()){
            container.put("estoque", estoque)
        }
        var result = db.update("dbproduct", container, "codigo=$codigo", null)
        db.close()
        return result

    }

    //Func para deletar um produto da db
    fun deleteProduct(codigo: String) : Int{
        val db = this.writableDatabase
        val result = db.delete("dbproduct", "codigo=$codigo$", null)
        db.close()
        return result
    }





}