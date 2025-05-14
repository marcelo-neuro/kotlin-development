package com.github.marcelo_neuro.listas.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ObraRepository(private val context: Context) {
    fun carregarObras(): List<ObraArte> {
        val json = context.assets.open("obras.json").bufferedReader().use {
            it.readText()
        }

        val tipo = object : TypeToken<List<ObraArte>>() {}.type
        return Gson().fromJson(json, tipo)
    }
}