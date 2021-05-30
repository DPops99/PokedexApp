package com.example.pokedexapp.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedexapp.network.model.*
import com.example.pokedexapp.room.converter.AbilityConverter
import com.example.pokedexapp.room.converter.NARConverter
import com.example.pokedexapp.room.converter.StatsConverter
import com.example.pokedexapp.room.converter.TypeConverter
import com.example.pokedexapp.room.dao.PokemonDao

@Database(entities = [Pokemon::class],version = 1, exportSchema = false)
@TypeConverters(AbilityConverter::class, TypeConverter::class, StatsConverter::class, NARConverter::class)
abstract class AppDatabase : RoomDatabase(){

    abstract fun pokemonDao() : PokemonDao

    companion object{

        var instance: AppDatabase? = null

        fun getInstance(context: Context):AppDatabase?{
            if (instance==null){
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "myDB").build()
                }
            }
            return instance
        }
    }
}