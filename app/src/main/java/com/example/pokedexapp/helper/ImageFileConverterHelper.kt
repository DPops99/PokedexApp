package com.example.pokedexapp.helper

import android.util.Log
import com.example.pokedexapp.network.model.Pokemon

object ImageFileConverterHelper {

    fun getImageFile(pokemon : Pokemon):String{
        Log.d("DANIJEL_IMG","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/".plus(pokemon.id).plus(".png"))
         return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/".plus(pokemon.id).plus(".png")
    }
}