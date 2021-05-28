package com.example.pokedexapp.network.api

import com.example.pokedexapp.network.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/pokemon/{id_or_name}/")
    suspend fun getPokemon(@Path("id_or_name") value : String) : Pokemon

    @GET("/pokemon/")
    suspend fun getPokemons()

}