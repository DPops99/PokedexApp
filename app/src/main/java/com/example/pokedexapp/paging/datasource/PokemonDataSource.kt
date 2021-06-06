package com.example.pokedexapp.paging.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PageKeyedDataSource
import com.example.pokedexapp.network.api.PokemonService
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.model.PokemonList
import com.example.pokedexapp.network.repository.Repository
import com.example.pokedexapp.room.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PokemonDataSource (
    private val coroutineScope: CoroutineScope,
    private val roomDB : AppDatabase
        ):PageKeyedDataSource<Int, Pokemon>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Pokemon>
    ) {
        coroutineScope.launch {
            val pokemonList = Repository().getPokemons2(20,0)
            Log.d("DANIJEL_POK",pokemonList.toString())

//            var helper = ArrayList<Pokemon>()
            val result = async {
                for (pokemon_NAR in pokemonList.results) {
                    async {
                        val pokemon = Repository().getPokemon(pokemon_NAR.name)
//                        val maxOrder = roomDB.pokemonDao().getLargerstOrder()
//                        pokemon.order = maxOrder+1
                        Log.d("DANIJEL_EACH_POK", pokemon.toString())
//                        helper.add(pokemon)
                        roomDB.pokemonDao().insert(pokemon)
                    }
                }
            }

            result.await()
            when{
                result.isCompleted -> {
                    val data = roomDB.pokemonDao().getAll()
                    callback.onResult(data,0,20)
                }
            }
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int,Pokemon>) {
        coroutineScope.launch {
            val pokemonList = Repository().getPokemons2(20,0)
            Log.d("DANIJEL_POK",pokemonList.toString())

//            var helper = ArrayList<Pokemon>()
            val result = async {
                for (pokemon_NAR in pokemonList.results) {
                    async {
                        val pokemon = Repository().getPokemon(pokemon_NAR.name)
//                        val maxOrder = roomDB.pokemonDao().getLargerstOrder()
//                        pokemon.order = maxOrder+1
                        Log.d("DANIJEL_EACH_POK", pokemon.toString())
//                        helper.add(pokemon)
                        roomDB.pokemonDao().insert(pokemon)
                    }
                }
            }

            result.await()
            when{
                result.isCompleted -> {
                    val data = roomDB.pokemonDao().getAll()
                    callback.onResult(data,40)
                }
            }
        }
    }
}

