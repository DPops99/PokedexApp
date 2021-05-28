package com.example.pokedexapp.network.model

data class PokemonAbility (
    var is_hidden : Boolean,
    var ability: Ability
        )

data class Ability (
    var name : String,
    var url : String
)