package com.example.pokedexapp.network.api

import com.example.pokedexapp.network.model.EvolutionChain
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.model.PokemonList
import com.example.pokedexapp.network.model.PokemonSpecies
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

}