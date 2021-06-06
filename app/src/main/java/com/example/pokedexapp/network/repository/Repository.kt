package com.example.pokedexapp.network.repository

import android.util.Log
import com.example.pokedexapp.network.api.PokemonService
import com.example.pokedexapp.network.model.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val service : PokemonService
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    init {

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        service = retrofit.create(PokemonService::class.java)
    }

    suspend fun getPokemon(value :String) : Pokemon{
        return service.getPokemon(value)
    }

    suspend fun getPokemons():PokemonList{
        Log.d("DANIJEL_POK","in repository")
        return service.getPokemons()
    }


    suspend fun getPokemons2(limit: Int, offset: Int):PokemonList{
        Log.d("DANIJEL_POK","in repository")
        return service.getPokemons2(limit, offset)
    }

    suspend fun getEvolutionChain(value: String):EvolutionChain{
        return service.getEvolutionChain(value)
    }

    suspend fun getPokemonSpecies(value: String):PokemonSpecies{
        return service.getPokemonSpecies(value)
    }

    suspend fun getTypes(value: String):Types{
        return service.getTypes(value)
    }

    suspend fun getMove(value: String):Move{
        return service.getMove(value)
    }
}