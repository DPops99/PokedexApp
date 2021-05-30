package com.example.pokedexapp.room.converter

import androidx.room.TypeConverter
import com.example.pokedexapp.network.model.PokemonAbility
import com.google.gson.Gson

class AbilityConverter {

    @TypeConverter
    fun listToJson(value:List<PokemonAbility>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<PokemonAbility>::class.java).toList()
}