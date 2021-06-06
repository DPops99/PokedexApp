package com.example.pokedexapp.network.api

import com.example.pokedexapp.network.model.*
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{id_or_name}/")
    suspend fun getPokemon(@Path("id_or_name") value : String) : Pokemon

    @GET("pokemon/")
    suspend fun getPokemons() : PokemonList

    @GET("{id}")
    suspend fun getEvolutionChain(@Path("id") value: String) : EvolutionChain

    @GET("pokemon-species/{id}/")
    suspend fun getPokemonSpecies(@Path("id") value: String) : PokemonSpecies

    @GET("type/{id_or_name}/")
    suspend fun getTypes(@Path("id_or_name") value: String): Types

    @GET("move/{id or name}/")
    suspend fun getMove(@Path("id_or_name") value: String):Move

}