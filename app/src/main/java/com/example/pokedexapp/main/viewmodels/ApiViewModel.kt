package com.example.pokedexapp.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.repository.Repository
import kotlinx.coroutines.launch

class ApiViewModel : ViewModel(){

    val api_pokemon = MutableLiveData<Pokemon>()

    fun get_pokemon(value : String){

        viewModelScope.launch {
            api_pokemon.value = Repository().getPokemon(value)
        }
    }
}