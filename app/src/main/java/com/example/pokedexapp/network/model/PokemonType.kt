package com.example.pokedexapp.network.model

data class PokemonType (
    var slot : Int,
    var type : Type
        )

data class Type(
    var name : String,
    var url : String
)