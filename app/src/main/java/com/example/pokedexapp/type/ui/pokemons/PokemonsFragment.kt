package com.example.pokedexapp.type.ui.pokemons

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexapp.databinding.TypeDamageFragmentLayoutBinding
import com.example.pokedexapp.databinding.TypePokemonsFragmentLayoutBinding
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.pokemon.adapter.EvolutionAdapter
import com.example.pokedexapp.type.viewmodel.TypeViewModel

class PokemonsFragment : Fragment() {

    private lateinit var _binding : TypePokemonsFragmentLayoutBinding
    private val binding get() = _binding!!
    private val typeApiViewModel : TypeViewModel by activityViewModels()
    private lateinit var adapter: EvolutionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = TypePokemonsFragmentLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("DANIJEL_POKEMON_F","enter")


//        typeApiViewModel.getPokemonTypes()




        adapter = EvolutionAdapter(ArrayList<Pokemon>() as List<Pokemon>, requireContext(), -1)
        binding.pokFragRv.adapter = adapter
        binding.pokFragRv.layoutManager = GridLayoutManager(requireContext(), 3)

        typeApiViewModel.api_pokemon.observe(viewLifecycleOwner, Observer {
            Log.d("DANIJEL_P",it.toString())
            adapter.chains = it as List<Pokemon>
            adapter.notifyDataSetChanged()
        })

        return view
    }
}