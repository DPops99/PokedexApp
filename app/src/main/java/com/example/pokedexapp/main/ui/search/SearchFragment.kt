package com.example.pokedexapp.main.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexapp.adapter.PokemonCardAdapter
import com.example.pokedexapp.databinding.SearchFragmentLayoutBinding
import com.example.pokedexapp.main.viewmodels.ApiViewModel
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.pokemon.PokemonActivity
import com.example.pokedexapp.room.viewmodel.RoomFactory
import com.example.pokedexapp.room.viewmodel.RoomViewModel

class SearchFragment : Fragment(), PokemonCardAdapter.OnItemClickListener, PokemonCardAdapter.OnFavClickListener {

    private lateinit var _binding : SearchFragmentLayoutBinding
    private val binding get() = _binding!!
    private lateinit var adapter: PokemonCardAdapter
//    private val pokemonModel : ApiViewModel by activityViewModels()
    private lateinit var pokemonRoom : RoomViewModel
    private lateinit var factory: RoomFactory
    val current_pokemon = "CURRENT_POKEMON"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentLayoutBinding.inflate(inflater,container, false)
        val view = binding.root

        factory = RoomFactory(requireContext())
        pokemonRoom = ViewModelProvider(this, factory).get(RoomViewModel::class.java)

        setView()

        return view
    }

    fun setView(){


        adapter = PokemonCardAdapter(ArrayList(),requireContext(), this, this )
        binding.searchRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRv.adapter = adapter

//        pokemonModel.apiPokemons.observe(viewLifecycleOwner, Observer {
////            adapter.pokemons = it
////            adapter.notifyDataSetChanged()
//            pokemonRoom.insertAll(it)
//        })

        pokemonRoom.pokemons.observe(viewLifecycleOwner, Observer {
                adapter.pokemons = it
                adapter.notifyDataSetChanged()

        })

//        pokemonRoom.pokemons.observe(viewLifecycleOwner, Observer {
//            pokemonModel.getPokemonList()
//        })


    }

    override fun onClick(position: Int) {
        Log.d("DANIJEL_LISTENER",adapter.pokemons[position].toString())

        startPokemonActivity(position)
    }

    override fun onClick(position: Int, isFav: Boolean) {
        var fav_pokemon = adapter.pokemons[position]
        fav_pokemon.isFavorite = isFav
        pokemonRoom.insert(fav_pokemon)
    }

    fun startPokemonActivity(position: Int){
        val intent = Intent(this.context, PokemonActivity::class.java)
        intent.putExtra(current_pokemon, adapter.pokemons[position])
        startActivity(intent)
    }


}