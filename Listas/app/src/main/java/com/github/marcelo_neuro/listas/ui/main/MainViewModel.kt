package com.github.marcelo_neuro.listas.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.marcelo_neuro.listas.data.ObraArte
import com.github.marcelo_neuro.listas.data.ObraRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = ObraRepository(application)
    private val _lista = MutableLiveData<List<ObraArte>>()
    val lista : LiveData<List<ObraArte>> get() = _lista

    init {
        _lista.value = repo.carregarObras()
    }
}