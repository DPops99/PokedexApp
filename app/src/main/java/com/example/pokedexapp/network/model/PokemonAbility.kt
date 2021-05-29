package com.example.pokedexapp.network.model

import java.io.Serializable

data class PokemonAbility (
    var is_hidden : Boolean,
    var ability: Ability
        ) :Serializable

data class Ability (
    var name : String,
    var url : String
):Serializable