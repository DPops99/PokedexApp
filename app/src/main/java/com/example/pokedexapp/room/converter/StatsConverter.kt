package com.example.pokedexapp.room.converter

import androidx.room.TypeConverter
import com.example.pokedexapp.network.model.PokemonStat
import com.google.gson.Gson

class StatsConverter {

    @TypeConverter
    fun listToJson(value:List<PokemonStat>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<PokemonStat>::class.java).toList()
}