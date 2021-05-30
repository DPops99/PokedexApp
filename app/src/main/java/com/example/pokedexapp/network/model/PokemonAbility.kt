package com.example.pokedexapp.network.model

import androidx.room.Entity
import java.io.Serializable


data class PokemonAbility (
    var is_hidden : Boolean,
    var ability: NamedApiResource
        ) :Serializable
