package com.example.onces20.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onces20.model.productos
import com.example.onces20.repositorio.repo

class LibraryViewModel: ViewModel(){
        val repo=repo()
    fun libraryData():LiveData<MutableList<productos>>{
        val mutabledata=MutableLiveData<MutableList<productos>>()
        repo.getlibraryData().observeForever{ result->
            mutabledata.value=result
        }
        return mutabledata
    }
}