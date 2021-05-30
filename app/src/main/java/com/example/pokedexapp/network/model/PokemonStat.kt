package com.example.pokedexapp.network.model

import androidx.room.Entity
import java.io.Serializable


data class PokemonStat (
    var stat: NamedApiResource,
    var effort : Int,
    var base_stat : Int
        ):Serializable
