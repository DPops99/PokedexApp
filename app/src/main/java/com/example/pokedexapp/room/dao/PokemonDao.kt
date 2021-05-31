package com.example.pokedexapp.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedexapp.network.model.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons : List<Pokemon>)

    @Query("SELECT * FROM pokemons")
    suspend fun getAll():List<Pokemon>

    @Query("SELECT * FROM pokemons WHERE isFavorite = 1 ORDER BY pOrder DESC")
    suspend fun getAllFavorite() : List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: Pokemon)

    @Query("SELECT MAX(pOrder) FROM pokemons")
    suspend fun getLargerstOrder() : Int
}