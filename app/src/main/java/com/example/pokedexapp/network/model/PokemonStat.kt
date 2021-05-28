package com.example.pokedexapp.network.model

data class PokemonStat (
    var stat: Stat,
    var effort : Int,
    var base_stat : Int
        )


data class Stat(
    var name : String,
    var url : String
)