package com.example.pokedexapp.network.model

import java.io.Serializable

data class PokemonType (
    var slot : Int,
    var type : Type
        ): Serializable

data class Type(
    var name : String,
    var url : String
):Serializable