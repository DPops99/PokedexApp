package com.example.pokedexapp.main.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ApiViewModel : ViewModel(){

    val apiPokemons = MutableLiveData<ArrayList<Pokemon>>()



    init {
        Log.d("DANIJEL_POK","init")
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            val pokemonList = Repository().getPokemons()
            Log.d("DANIJEL_POK",pokemonList.toString())
            var helper = ArrayList<Pokemon>()
            for (pokemon_NAR in pokemonList.results){
                    val pokemon = Repository().getPokemon(pokemon_NAR.name)
                    Log.d("DANIJEL_EACH_POK",pokemon.toString())
                    helper.add(pokemon)
                }
            apiPokemons.value = helper
        }
    }
}