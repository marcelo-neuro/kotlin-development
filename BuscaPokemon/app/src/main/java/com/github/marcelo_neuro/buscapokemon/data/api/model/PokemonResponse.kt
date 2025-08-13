package com.github.marcelo_neuro.buscapokemon.data.api.model

data class PokemonResponse(
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprite
) {
}