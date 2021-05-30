package com.example.pokedexapp.network.model

import androidx.room.Entity


data class PokemonList (
    var count : Int,
    var next : String,
    var previous : Boolean,
    var results : List<NamedApiResource>
        )

