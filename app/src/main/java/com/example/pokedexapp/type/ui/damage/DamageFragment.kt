package com.example.pokedexapp.type.ui.damage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.SearchFragmentLayoutBinding
import com.example.pokedexapp.databinding.TypeDamageFragmentLayoutBinding
import com.example.pokedexapp.helper.StringGeneratorHelper
import com.example.pokedexapp.pokemon.PokemonActivity
import com.example.pokedexapp.type.viewmodel.TypeFactory
import com.example.pokedexapp.type.viewmodel.TypeViewModel
import com.google.android.material.chip.Chip

class DamageFragment :Fragment(){

    private lateinit var _binding : TypeDamageFragmentLayoutBinding
    private val binding get() = _binding!!
    private val typeApiViewModel : TypeViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = TypeDamageFragmentLayoutBinding.inflate(inflater, container, false)
        val view = binding.root

        activity?.intent?.let {
            it.getStringExtra(PokemonActivity()?.current_type!!)?.let { it1 -> typeApiViewModel.getTypes(it1) }
        }

        setView()
        return view
    }

    fun setView(){

        binding.fromTwice.damageText.text = getString(R.string.twice)
        binding.fromHalf.damageText.text = getString(R.string.half)
        binding.fromZero.damageText.text = getString(R.string.zero)
        binding.toTwice.damageText.text = getString(R.string.twice)
        binding.toHalf.damageText.text = getString(R.string.half)
        binding.toZero.damageText.text = getString(R.string.zero)

        typeApiViewModel.api_types.observe(viewLifecycleOwner, Observer {
            for (item in it.damage_relations.double_damage_from) {
                val chip = Chip(requireContext())
                chip.text = item.name
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                Log.d("DANIJEL_BACK",StringGeneratorHelper.getColorId("bug", requireContext()).toString().plus(" ").plus(R.color.flat_pokemon_type_bug))
                binding.fromTwice.damageChips.addView(chip)
            }
            for (item in it.damage_relations.half_damage_from) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                binding.fromHalf.damageChips.addView(chip)
            }
            for (item in it.damage_relations.no_damage_from) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                binding.fromZero.damageChips.addView(chip)
            }
            for (item in it.damage_relations.double_damage_to) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                binding.toTwice.damageChips.addView(chip)
            }
            for (item in it.damage_relations.half_damage_to) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                binding.toHalf.damageChips.addView(chip)
            }
            for (item in it.damage_relations.no_damage_to) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                binding.toZero.damageChips.addView(chip)
            }
        })


    }
}