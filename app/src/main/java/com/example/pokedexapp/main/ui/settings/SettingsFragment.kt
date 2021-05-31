package com.example.pokedexapp.main.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexapp.about.AboutActivity
import com.example.pokedexapp.databinding.SettingsFragmentLayoutBinding
import com.example.pokedexapp.room.viewmodel.RoomFactory
import com.example.pokedexapp.room.viewmodel.RoomViewModel

class SettingsFragment : Fragment() {

    private lateinit var _binding : SettingsFragmentLayoutBinding
    private val binding get() = _binding!!
    private lateinit var pokemonRoom : RoomViewModel
    private lateinit var factory: RoomFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SettingsFragmentLayoutBinding.inflate(inflater,container, false)
        val view = binding.root

        factory = RoomFactory(requireContext())
        pokemonRoom = ViewModelProvider(this, factory).get(RoomViewModel::class.java)

        setListeners()
        return view
    }

    fun setListeners(){
        binding.clearFavBtn.setOnClickListener {
            pokemonRoom.deleteFavPokemons()
        }

        binding.moreInfoBtn.setOnClickListener {
            startActivity(Intent(requireContext(), AboutActivity::class.java))
        }
    }
}