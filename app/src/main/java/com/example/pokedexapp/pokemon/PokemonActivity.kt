package com.example.pokedexapp.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.ActivityPokemonBinding
import com.example.pokedexapp.helper.ImageFileConverterHelper
import com.example.pokedexapp.main.ui.search.SearchFragment
import com.example.pokedexapp.network.model.Pokemon

class PokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setView()
    }

    fun setView(){

        setSupportActionBar(binding.pokemonToolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }



        intent?.getSerializableExtra(SearchFragment().current_pokemon)?.let {
            val current_pokemon = it as Pokemon

            binding.pokemonName.text = current_pokemon.name
            binding.pokemonNum.text = current_pokemon.id.toString()
            binding.pokemonImg.load(ImageFileConverterHelper.getImageFile(current_pokemon))
            binding.pokemonFav.load(R.drawable.ic_star_1)
        }
    }
}