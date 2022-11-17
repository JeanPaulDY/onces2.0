package com.example.onces20.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.onces20.R
import android.content.Context
import com.example.onces20.model.productos
import com.squareup.picasso.Picasso

class ProductosAdapter(private val context:Context): RecyclerView.Adapter<ProductosAdapter.ViewHolder>() {
    private var productosLista= mutableListOf<productos>()

    fun setListData(data:MutableList<productos>){
        productosLista=data
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder{
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_onces,
            viewGroup, false)
        return ViewHolder(v)
    }
        inner class ViewHolder(ItemView:View): RecyclerView.ViewHolder(ItemView){
            fun binWew(productos: productos){
                itemView.findViewById<TextView>(R.id.title1).text=productos.producto
                itemView.findViewById<TextView>(R.id.precio).text=productos.precio
                Picasso.with(context).load(productos.image).into(itemView.findViewById<ImageView>(R.id.image1))
            }
        }

    val titles= arrayOf("Combo 1", "Combo 2", "Combo 3", "Combo 4", "Combo 5", "Combo 6")
    val precio= arrayOf("$30.000", "$42.000", "$38.000", "$35.000", "$40.000", "$50.000")
    val image= arrayOf(R.drawable.combo1,R.drawable.combo2, R.drawable.combo3, R.drawable.combo4, R.drawable.combo5, R.drawable.combo6)

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
       val producto=productosLista[i]
        viewHolder.binWew(producto)
    }

    override fun getItemCount(): Int {
        return if(productosLista.size>0){
            productosLista.size
        }else{
            0
        }
    }
}