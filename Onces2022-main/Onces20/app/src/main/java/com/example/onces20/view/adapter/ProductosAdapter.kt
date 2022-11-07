package com.example.onces20.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.onces20.R

class ProductosAdapter: RecyclerView.Adapter<ProductosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder{
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_onces,
            viewGroup, false)
        return ViewHolder(v)
    }
        inner class ViewHolder(ItemView:View): RecyclerView.ViewHolder(ItemView){
            var itemImage: ImageView
            var itemTitle: TextView
            var itemPrecio: TextView

            init {
                itemImage=ItemView.findViewById(R.id.image1)
                itemTitle=ItemView.findViewById(R.id.title1)
                itemPrecio=ItemView.findViewById(R.id.precio)
            }
        }

    val titles= arrayOf("Combo 1", "Combo 2", "Combo 3", "Combo 4", "Combo 5", "Combo 6")
    val precio= arrayOf("$30.000", "$42.000", "$38.000", "$35.000", "$40.000", "$50.000")
    val image= arrayOf(R.drawable.combo1,R.drawable.combo2, R.drawable.combo3, R.drawable.combo4, R.drawable.combo5, R.drawable.combo6)

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemPrecio.text=precio[i]
        viewHolder.itemImage.setImageResource(image[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}