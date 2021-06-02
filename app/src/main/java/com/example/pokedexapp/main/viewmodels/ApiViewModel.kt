package com.example.pokedexapp.main.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.network.model.EvolutionChain
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.model.PokemonList
import com.example.pokedexapp.network.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ApiViewModel : ViewModel(){

    val apiPokemons = MutableLiveData<ArrayList<Pokemon>>()
    val apiEvolutionChain = MutableLiveData<EvolutionChain>()


    init {

    }

    fun getPokemonList() {
        viewModelScope.launch {
            val pokemonList = Repository().getPokemons()
            Log.d("DANIJEL_POK",pokemonList.toString())

            var helper = ArrayList<Pokemon>()
            val result = viewModelScope.async {
                for (pokemon_NAR in pokemonList.results) {
                    viewModelScope.async {
                        val pokemon = Repository().getPokemon(pokemon_NAR.name)

                        Log.d("DANIJEL_EACH_POK", pokemon.toString())
                        helper.add(pokemon)
                    }
                }
            }
            result.await()
            apiPokemons.value = helper
        }
    }

    fun getPokemonSpecies(pokemon: Pokemon){
        viewModelScope.launch {
            val specie = Repository().getPokemonSpecies(pokemon.id.toString())
            Log.d("DANIJEL_SPECIES",specie.toString())
            val newUrl = specie.evolution_chain.url.takeLast(specie.evolution_chain.url.length-26)
            getEvoulutionChain(newUrl)
        }
    }

    fun getEvoulutionChain(value : String){
        viewModelScope.launch {
            apiEvolutionChain.value = Repository().getEvolutionChain(value)
            var helper = ArrayList<Pokemon>()
            helper.add(Repository().getPokemon(apiEvolutionChain.value?.chain?.species?.name!!))
            var current_field = apiEvolutionChain.value?.chain?.evolves_to
            while(current_field?.size != 0){
                helper.add(Repository().getPokemon(current_field?.get(0)?.species?.name!!))
                current_field = current_field?.get(0)?.evolves_to
            }

            apiPokemons.value = helper
            Log.d("DANIJEL_RESULT_EVOL",apiPokemons.value.toString())
        }
    }

}