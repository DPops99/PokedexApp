package com.example.pokedexapp.network.repository

import com.example.pokedexapp.network.api.PokemonService
import com.example.pokedexapp.network.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val service : PokemonService
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    init {

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonService::class.java)
    }

    suspend fun getPokemon(value :String) : Pokemon{
        return service.getPokemon(value)
    }
}