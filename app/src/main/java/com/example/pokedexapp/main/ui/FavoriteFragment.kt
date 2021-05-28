package com.example.pokedexapp.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexapp.databinding.FavoriteFragmentLayoutBinding
import com.example.pokedexapp.databinding.SearchFragmentLayoutBinding

class FavoriteFragment : Fragment() {

    private lateinit var _binding : FavoriteFragmentLayoutBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavoriteFragmentLayoutBinding.inflate(inflater,container, false)
        val view = binding.root



        return view
    }
}