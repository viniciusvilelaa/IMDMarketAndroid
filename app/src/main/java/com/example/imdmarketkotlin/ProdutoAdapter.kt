package com.example.imdmarketkotlin

import Produto
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

//Classe de configuração do RecycleView Adapter
class ProdutoAdapter(private val produtos: List<Produto>) : RecyclerView.Adapter<ProdutoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtos[position]

        holder.bind(produto)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

}