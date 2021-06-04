package com.example.pokedexapp.type.ui.pokemons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexapp.databinding.TypeDamageFragmentLayoutBinding
import com.example.pokedexapp.databinding.TypePokemonsFragmentLayoutBinding

class PokemonsFragment : Fragment() {

    private lateinit var _binding : TypePokemonsFragmentLayoutBinding
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = TypePokemonsFragmentLayoutBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }
}