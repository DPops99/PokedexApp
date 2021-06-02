package com.example.pokedexapp.pokemon.model

import com.example.pokedexapp.network.model.ApiResource
import com.example.pokedexapp.network.model.ChainLink
import com.example.pokedexapp.network.model.Pokemon
import java.io.Serializable

data class EvolutionModel (
        var id : Int,
        var name : String,
        var evolution_chain : ApiResource
        ) : Serializable