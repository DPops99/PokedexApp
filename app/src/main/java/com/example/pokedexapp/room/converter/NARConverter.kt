package com.example.pokedexapp.room.converter

import androidx.room.TypeConverter
import com.example.pokedexapp.network.model.NamedApiResource
import com.example.pokedexapp.network.model.PokemonType
import com.google.gson.Gson

class NARConverter {

    @TypeConverter
    fun listToJson(value:NamedApiResource?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, NamedApiResource::class.java)
}