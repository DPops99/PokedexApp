package com.example.pokedexapp.type.ui.moves

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.pokedexapp.databinding.TypeDamageFragmentLayoutBinding
import com.example.pokedexapp.databinding.TypeMovesFragmentLayoutBinding
import com.example.pokedexapp.type.viewmodel.TypeViewModel

class MovesFragment : Fragment() {

    private lateinit var _binding : TypeMovesFragmentLayoutBinding
    private val binding get() = _binding!!
//    private val typeApiViewModel : TypeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = TypeMovesFragmentLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("DANIJEL_MOVE","enter")

//        typeApiViewModel.api_types.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                typeApiViewModel.getMoves()
//            }
//        })
//
//        typeApiViewModel.api_moves.observe(viewLifecycleOwner, Observer {
//            Log.d("DANJEL_MOVES",it.toString())
//        })
        return view
    }
}