package com.github.marcelo_neuro.buscapokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.marcelo_neuro.buscapokemon.data.PokemonRepository
import com.github.marcelo_neuro.buscapokemon.data.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    private val repository = PokemonRepository(RetrofitClient.pokemonApi)

    var pokemonDetails: String = ""
    var pokemonsSprites: List<String> = emptyList()

    fun fetchPokemon(id: Int, onResult: (String, List<String>) -> Unit) {
        viewModelScope.launch {
            val (details, sprites) = repository.getPokemon(id)
            withContext(Dispatchers.Main) {
                pokemonDetails = details
                pokemonsSprites = sprites
                onResult(details, sprites)
            }
        }
    }
}