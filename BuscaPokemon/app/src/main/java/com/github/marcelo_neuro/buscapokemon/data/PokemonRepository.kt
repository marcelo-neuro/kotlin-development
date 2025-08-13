package com.github.marcelo_neuro.buscapokemon.data

import com.github.marcelo_neuro.buscapokemon.data.api.PokemonAPI

class PokemonRepository(private val api: PokemonAPI) {
    suspend fun getPokemon(id: Int): Pair<String, List<String>> {
        val response = api.getPokemon(id)
        val details = "Name: ${response.name}, Weight: ${response.weight}, Height: ${response.height}"
        val sprites = listOfNotNull(
            response.sprites.frontDefault,
            response.sprites.backDefault,
            response.sprites.frontShiny,
            response.sprites.backShiny
        )

        return Pair(details, sprites)
    }
}