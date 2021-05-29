package com.example.pokedexapp.network.model

import java.io.Serializable

data class PokemonStat (
    var stat: Stat,
    var effort : Int,
    var base_stat : Int
        ):Serializable


data class Stat(
    var name : String,
    var url : String
):Serializable