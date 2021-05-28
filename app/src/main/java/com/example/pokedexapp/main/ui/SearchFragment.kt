package com.example.pokedexapp.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexapp.databinding.SearchFragmentLayoutBinding

class SearchFragment : Fragment() {

    private lateinit var _binding : SearchFragmentLayoutBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchFragmentLayoutBinding.inflate(inflater,container, false)
        val view = binding.root



        return view
    }
}