package com.example.pokedexapp.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.ActivityPokemonBinding

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


    }
}