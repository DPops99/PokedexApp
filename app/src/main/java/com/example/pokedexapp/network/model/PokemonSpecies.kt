package com.example.pokedexapp.network.model

import java.io.Serializable

data class PokemonSpecies (
        var id : Int,
        var name : String,
        var evolution_chain : ApiResource
        ): Serializable