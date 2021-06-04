package com.example.pokedexapp.helper

import android.content.Context
import android.util.Log
import com.example.pokedexapp.R
import com.example.pokedexapp.network.model.Pokemon

object StringGeneratorHelper {

    val basic_color_string = "@color/flat_pokemon_type_"
    val basic_image_file = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

    fun getImageFile(pokemon : Pokemon):String{
        Log.d("DANIJEL_IMG", basic_image_file.plus(pokemon.id).plus(".png"))
         return basic_image_file.plus(pokemon.id).plus(".png")
    }

    fun getColorId(value : String, context: Context):Int{
        Log.d("DANIJEL_COLOR_ID",context.resources.getIdentifier(basic_color_string.plus(value), null, context.packageName).toString())
        return  context.resources.getIdentifier(basic_color_string.plus(value), null, context.packageName)
    }
}