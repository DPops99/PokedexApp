package com.example.pokedexapp.network.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pokedexapp.room.converter.AbilityConverter
import com.example.pokedexapp.room.converter.NARConverter
import com.example.pokedexapp.room.converter.StatsConverter
import com.example.pokedexapp.room.converter.TypeConverter
import java.io.Serializable

@Entity(tableName = "pokemons")
data class Pokemon (
    @PrimaryKey
    var id : Int,
    @ColumnInfo(name="pokemon_name")
    var name : String,
    var height : Int,
    var weight : Int,
    @ColumnInfo(name="abilities")
    @TypeConverters(AbilityConverter::class)
    var abilities : List<PokemonAbility>,
    @ColumnInfo(name="stats")
    @TypeConverters(StatsConverter::class)
    var stats : List<PokemonStat>,
    @ColumnInfo(name = "types")
    @TypeConverters(TypeConverter::class)
    var types : List<PokemonType>,
    @Transient
    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean,
    @Transient
    @ColumnInfo(name = "pOrder")
    var order: Int=0,
    @TypeConverters(NARConverter::class)
    var species : NamedApiResource
        ) : Serializable
//{
//            constructor(id : Int, name : String, height: Int):
//                    this(id,name,height,ArrayList<PokemonAbility>(), ArrayList<PokemonStat>(),ArrayList<PokemonType>(),null)
//        }
