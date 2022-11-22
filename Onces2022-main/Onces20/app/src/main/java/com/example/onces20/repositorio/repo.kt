package com.example.onces20.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.onces20.model.compras
import com.example.onces20.model.productos
import com.google.firebase.database.MutableData
import com.google.firebase.firestore.FirebaseFirestore

class repo {
    fun getlibraryData():LiveData<MutableList<productos>>{
        val mutableData=MutableLiveData<MutableList<productos>>()
        FirebaseFirestore.getInstance().collection("Productos").get().addOnSuccessListener {
            result->
            val listData= mutableListOf<productos>()
            for (document in result){
                val titulo=document.getString("titulo")
                val precio=document.getString("precio")
                val image=document.getString("image")
                val producto=productos(titulo!!,precio!!,image!!)
                listData.add(producto)
            }
            mutableData.value=listData
        }
        return mutableData
    }

    fun getComprasData():LiveData<MutableList<compras>>{
        val mutableData=MutableLiveData<MutableList<compras>>()
        FirebaseFirestore.getInstance().collection("compras")
            .get().addOnSuccessListener {
                result->
                val listData= mutableListOf<compras>()
                for (document in result){
                    val productos=document.getString("titulo")
                    val precio=document.getString("precio")
                    val image=document.getString("image")
                    val compra=compras(productos!!,precio!!,image!!)
                    listData.add(compra)
                }
                mutableData.value=listData
            }
        return mutableData
    }
}