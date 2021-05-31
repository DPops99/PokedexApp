package com.example.pokedexapp.main.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.adapter.PokemonCardAdapter
import com.example.pokedexapp.databinding.FavoriteFragmentLayoutBinding
import com.example.pokedexapp.main.viewmodels.ApiViewModel
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.pokemon.PokemonActivity
import com.example.pokedexapp.room.viewmodel.RoomFactory
import com.example.pokedexapp.room.viewmodel.RoomViewModel


class FavoriteFragment : Fragment(), PokemonCardAdapter.OnItemClickListener, PokemonCardAdapter.OnFavClickListener {

    private lateinit var _binding : FavoriteFragmentLayoutBinding
    private val binding get() = _binding!!
    private lateinit var adapter: PokemonCardAdapter
    private val pokemonModel : ApiViewModel by activityViewModels()
    private lateinit var pokemonRoom : RoomViewModel
    private lateinit var factory: RoomFactory
    val current_pokemon = "CURRENT_POKEMON"
    private val itemTouchHelper by lazy {

        val simpleItemTouchCallback =
                object : ItemTouchHelper.SimpleCallback (ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0){
                    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {

                        val from = viewHolder.adapterPosition
                        val to = target.adapterPosition

                        adapter.moveItem(from,to)
                        adapter.notifyDataSetChanged()

                        return true
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    }

                }
        ItemTouchHelper(simpleItemTouchCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavoriteFragmentLayoutBinding.inflate(inflater,container, false)
        val view = binding.root

        factory = RoomFactory(requireContext())
        pokemonRoom = ViewModelProvider(this, factory).get(RoomViewModel::class.java)

        setView()
        setListeners()

        return view
    }

    fun setView(){

        adapter = PokemonCardAdapter(ArrayList(),requireContext(),this, this)
        binding.favoriteRV.layoutManager = LinearLayoutManager(requireContext())
        binding.favoriteRV.adapter = adapter
        itemTouchHelper.attachToRecyclerView(null)

        pokemonRoom.fav_pokemons.observe(viewLifecycleOwner, Observer {
            adapter.pokemons = it as ArrayList<Pokemon>
            adapter.notifyDataSetChanged()
        })

    }

    fun setListeners(){

        binding.favEdit.setOnClickListener {
            if (binding.favEdit.tag==getString(R.string.tag_edit)){
                binding.favEdit.apply {
                    load(R.drawable.ic_baseline_check_24)
                    tag = getString(R.string.tag_check)
                }
                itemTouchHelper.attachToRecyclerView(binding.favoriteRV)
            }
            else {
                pokemonRoom.insertAll(adapter.pokemons)
                binding.favEdit.apply {
                    load(R.drawable.ic_edit)
                    tag = getString(R.string.tag_edit)
                }
                itemTouchHelper.attachToRecyclerView(null)
            }
        }

    }

    override fun onClick(position: Int) {
        startPokemonActivity(position)
    }

    fun startPokemonActivity(position: Int){
        val intent = Intent(this.context, PokemonActivity::class.java)
        intent.putExtra(current_pokemon, adapter.pokemons[position])
        startActivity(intent)
    }

    override fun onClick(position: Int, isFav: Boolean) {
        var fav_pokemon = adapter.pokemons[position]
        fav_pokemon.isFavorite = isFav
        pokemonRoom.insert(fav_pokemon)
    }
}