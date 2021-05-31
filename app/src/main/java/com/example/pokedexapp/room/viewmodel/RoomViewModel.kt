package com.example.pokedexapp.room.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.repository.Repository
import com.example.pokedexapp.room.database.AppDatabase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class RoomViewModel(context: Context) : ViewModel() {

    val pokemons = MutableLiveData<ArrayList<Pokemon>>()
    val fav_pokemons = MutableLiveData<ArrayList<Pokemon>>()
    val roomDB : AppDatabase


    init {
        roomDB = AppDatabase.getInstance(context)!!
        getPokemons()
        getFavoritePokemons()
    }


    fun init_pokemons(){
        viewModelScope.launch {
            val pokemonList = Repository().getPokemons()
            Log.d("DANIJEL_POK",pokemonList.toString())

//            var helper = ArrayList<Pokemon>()
            val result = viewModelScope.async {
                for (pokemon_NAR in pokemonList.results) {
                    viewModelScope.async {
                        val pokemon = Repository().getPokemon(pokemon_NAR.name)

                        Log.d("DANIJEL_EACH_POK", pokemon.toString())
//                        helper.add(pokemon)
                        roomDB.pokemonDao().insert(pokemon)
                    }
                }
            }
            result.await()

            pokemons.value = roomDB.pokemonDao().getAll() as ArrayList<Pokemon>


        }
    }


    fun getPokemons(){
        viewModelScope.launch {
            pokemons.value = roomDB.pokemonDao().getAll() as ArrayList<Pokemon>
            Log.d("DANIJEL_ROOM_GET",pokemons.value.toString())

            if (pokemons.value?.size == 0)
                init_pokemons()
        }
    }

    fun getFavoritePokemons(){
        viewModelScope.launch {
            fav_pokemons.value = roomDB.pokemonDao().getAllFavorite() as ArrayList<Pokemon>

        }
    }

    fun insert(pokemon: Pokemon){
        viewModelScope.launch {
            roomDB.pokemonDao().insert(pokemon)
            pokemons.value = roomDB.pokemonDao().getAll() as ArrayList<Pokemon>
            fav_pokemons.value = roomDB.pokemonDao().getAllFavorite() as ArrayList<Pokemon>
        }
    }

    fun insertAll(room_pokemons : ArrayList<Pokemon>){
        viewModelScope.launch {
            roomDB.pokemonDao().insertAll(room_pokemons as List<Pokemon>)
            pokemons.value = roomDB.pokemonDao().getAll() as ArrayList<Pokemon>
            fav_pokemons.value = roomDB.pokemonDao().getAllFavorite() as ArrayList<Pokemon>
        }
    }
}