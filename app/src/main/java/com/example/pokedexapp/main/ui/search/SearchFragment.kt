package com.example.pokedexapp.main.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexapp.adapter.PokemonCardAdapter
import com.example.pokedexapp.databinding.SearchFragmentLayoutBinding
import com.example.pokedexapp.main.viewmodels.ApiViewModel

class SearchFragment : Fragment() {

    private lateinit var _binding : SearchFragmentLayoutBinding
    private val binding get() = _binding!!
    private lateinit var adapter: PokemonCardAdapter
    private val pokemonModel : ApiViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentLayoutBinding.inflate(inflater,container, false)
        val view = binding.root

        setView()

        return view
    }

    fun setView(){


        adapter = PokemonCardAdapter(ArrayList(),requireContext())
        binding.searchRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRv.adapter = adapter

        pokemonModel.apiPokemons.observe(viewLifecycleOwner, Observer {
            adapter.pokemons = it
            adapter.notifyDataSetChanged()
        })


    }
}