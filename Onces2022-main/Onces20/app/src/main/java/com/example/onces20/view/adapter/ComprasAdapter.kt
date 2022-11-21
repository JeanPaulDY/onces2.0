package com.example.onces20.view.adapter

import android.view.LayoutInflater
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onces20.R
import com.example.onces20.model.compras
import com.squareup.picasso.Picasso


class ComprasAdapter(private val context: Context, var clickListener: OnCompraItemClickListener): RecyclerView.Adapter<ComprasAdapter.ViewHolder>() {
    private var productosLista = mutableListOf<compras>()

    fun setListData(data: MutableList<compras>) {
        productosLista = data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.card_view_compras,
            viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        fun binWew(productos: compras, action: OnCompraItemClickListener) {
            itemView.findViewById<TextView>(R.id.title1).text = productos.producto
            itemView.findViewById<TextView>(R.id.precio).text = productos.precio
            Picasso.with(context).load(productos.image).into(itemView.findViewById<ImageView>(R.id.image1))
            val btneliminar = itemView.findViewById<ImageButton>(R.id.eliminarcarrito)
            btneliminar.setOnClickListener {
                action.onItemClick(productos, adapterPosition)
            }
        }
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val producto = productosLista[i]
        viewHolder.binWew(producto, clickListener)
    }

    override fun getItemCount(): Int {
        return if (productosLista.size > 0) {
            productosLista.size
        } else {
            0
        }
    }
}

interface OnCompraItemClickListener {
    fun onItemClick(producto: compras, position:Int)
}
