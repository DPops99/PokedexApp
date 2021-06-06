package com.example.pokedexapp.type.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.network.model.Move
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.model.Types
import com.example.pokedexapp.network.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TypeViewModel : ViewModel() {

    var api_types = MutableLiveData<Types>()
    var api_moves = MutableLiveData<ArrayList<Move>>()
    var api_pokemon = MutableLiveData<ArrayList<Pokemon>>()

    init {
        Log.d("DANIJEL_TYPE",api_types.value.toString())
    }

    fun getTypes(type_name : String){
        if (api_types.value == null) {
            viewModelScope.launch {
                api_types.value = Repository().getTypes(type_name)
//                getMoves()
//                getPokemonTypes()
            }
        }
    }

    fun getMoves(){
        api_types.value?.let {
            viewModelScope.launch {
                var helper = ArrayList<Move>()
                val result = viewModelScope.async {
                    for (move in api_types.value?.moves!!) {
                        viewModelScope.async {
                            helper.add(Repository().getMove(move.name))
                        }
                    }
                }
                result.await()
                api_moves.value = helper

            }
        }
    }

    fun getPokemonTypes(){
        api_types.value?.let {
            viewModelScope.launch {
                var helper = ArrayList<Pokemon>()
                val result = viewModelScope.async {
                    for (pokemon in api_types.value?.pokemon!!) {
                        viewModelScope.async {
                            helper.add(Repository().getPokemon(pokemon.pokemon.name))
                        }
                    }
                }
                result.await()
                api_pokemon.value = helper
            }
        }
    }



}