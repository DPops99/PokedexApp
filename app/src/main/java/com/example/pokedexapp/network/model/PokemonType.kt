package com.example.pokedexapp.network.model

import androidx.room.Entity
import java.io.Serializable


data class PokemonType (
    var slot : Int,
    var type : NamedApiResource
        ): Serializable
