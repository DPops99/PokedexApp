package com.example.pokedexapp.room.converter

import androidx.room.TypeConverter
import com.example.pokedexapp.network.model.PokemonType
import com.google.gson.Gson

class TypeConverter {

    @TypeConverter
    fun listToJson(value:List<PokemonType>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<PokemonType>::class.java).toList()
}