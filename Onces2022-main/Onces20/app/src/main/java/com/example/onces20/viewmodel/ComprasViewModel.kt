package com.example.onces20.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onces20.model.compras
import com.example.onces20.repositorio.repo

class ComprasViewModel: ViewModel() {
    val repo=repo()
    fun fectchComprasData():LiveData<MutableList<compras>>{
        val mutableData=MutableLiveData<MutableList<compras>>()
        repo.getComprasData().observeForever {
            mutableData.value=it
        }
        return mutableData
    }
}