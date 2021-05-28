package com.example.pokedexapp.main.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexapp.databinding.SettingsFragmentLayoutBinding

class SettingsFragment : Fragment() {

    private lateinit var _binding : SettingsFragmentLayoutBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SettingsFragmentLayoutBinding.inflate(inflater,container, false)
        val view = binding.root



        return view
    }
}