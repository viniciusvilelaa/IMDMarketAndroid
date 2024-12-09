package com.example.imdmarketkotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Classe de configuração do RecycleView ViewHolder
class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(produto: Produto){
        itemView.findViewById<TextView>(R.id.codigoProduto).text = produto.getCodigo()
        itemView.findViewById<TextView>(R.id.nomeProduto).text = produto.getNome()
    }

}