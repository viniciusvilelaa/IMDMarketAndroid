package com.example.imdmarketkotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(produto: Produto){
        itemView.findViewById<TextView>(R.id.codigoProduto).text = produto.codigoProduto
        itemView.findViewById<TextView>(R.id.nomeProduto).text = produto.nomeProduto
    }

}