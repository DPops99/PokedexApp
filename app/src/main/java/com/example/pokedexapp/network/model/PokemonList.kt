package com.example.pokedexapp.network.model

data class PokemonList (
    var count : Int,
    var next : String,
    var previous : Boolean,
    var results : List<Pokemon_NAR>
        )

data class Pokemon_NAR(
    var name : String,
    var url : String
)