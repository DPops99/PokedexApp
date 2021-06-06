package com.example.pokedexapp.type.ui.damage

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
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
        binding.fromTwice.damageText.setTextColor(requireContext().resources.getColor(R.color.success))
        setCardBackColor(binding.fromTwice.reusableLl.background as LayerDrawable, getString(R.string.success),getString(R.string._success))

        binding.fromHalf.damageText.text = getString(R.string.half)
        binding.fromHalf.damageText.setTextColor(requireContext().resources.getColor(R.color.error))
        setCardBackColor(binding.fromHalf.reusableLl.background as LayerDrawable, getString(R.string.error),getString(R.string._error))

        binding.fromZero.damageText.text = getString(R.string.zero)
        binding.fromZero.damageText.setTextColor(requireContext().resources.getColor(R.color.surface_2))
        setCardBackColor(binding.fromZero.reusableLl.background as LayerDrawable,getString(R.string.cold_gray), getString(R.string.surface_2))

        binding.toTwice.damageText.text = getString(R.string.twice)
        binding.toTwice.damageText.setTextColor(requireContext().resources.getColor(R.color.success))
        setCardBackColor(binding.toTwice.reusableLl.background as LayerDrawable, getString(R.string.success), getString(R.string._success))

        binding.toHalf.damageText.text = getString(R.string.half)
        binding.toHalf.damageText.setTextColor(requireContext().resources.getColor(R.color.error))
        setCardBackColor(binding.toHalf.reusableLl.background as LayerDrawable, getString(R.string.error), getString(R.string._error))

        binding.toZero.damageText.text = getString(R.string.zero)
        binding.toZero.damageText.setTextColor(requireContext().resources.getColor(R.color.surface_2))
        setCardBackColor(binding.toZero.reusableLl.background as LayerDrawable,getString(R.string.cold_gray), getString(R.string.surface_2) )

        typeApiViewModel.api_types.observe(viewLifecycleOwner, Observer {
            for (item in it.damage_relations.double_damage_from) {
                val chip = Chip(requireContext())
                chip.text = item.name.capitalize()
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.setTextColor(resources.getColor(R.color.surface_1))
                Log.d("DANIJEL_BACK",StringGeneratorHelper.getColorId("bug", requireContext()).toString().plus(" ").plus(R.color.flat_pokemon_type_bug))
                binding.fromTwice.damageChips.addView(chip)
            }
            for (item in it.damage_relations.half_damage_from) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                chip.setTextColor(resources.getColor(R.color.surface_1))
                binding.fromHalf.damageChips.addView(chip)
            }
            for (item in it.damage_relations.no_damage_from) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                chip.setTextColor(resources.getColor(R.color.surface_1))
                binding.fromZero.damageChips.addView(chip)
            }
            for (item in it.damage_relations.double_damage_to) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                chip.setTextColor(resources.getColor(R.color.surface_1))
                binding.toTwice.damageChips.addView(chip)
            }
            for (item in it.damage_relations.half_damage_to) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                chip.setTextColor(resources.getColor(R.color.surface_1))
                binding.toHalf.damageChips.addView(chip)
            }
            for (item in it.damage_relations.no_damage_to) {
                val chip = Chip(requireContext())
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item.name, requireContext()))
                chip.text = item.name.capitalize()
                chip.setTextColor(resources.getColor(R.color.surface_1))
                binding.toZero.damageChips.addView(chip)
            }


            typeApiViewModel.getMoves()
        })

        typeApiViewModel.api_moves.observe(viewLifecycleOwner, Observer {
            Log.d("DANJEL_MOVES",it.toString())
        })

    }


    fun setCardBackColor(layerDrawable: LayerDrawable, valueR :String, valueB: String){
        val backDrawable : Drawable = layerDrawable.findDrawableByLayerId(R.id.back_id)
        val rectDrawable : Drawable = layerDrawable.findDrawableByLayerId(R.id.back_rec)
        backDrawable.setColorFilter(resources.getColor(StringGeneratorHelper.getCardColorId(valueB, requireContext())), PorterDuff.Mode.SRC_ATOP)
        rectDrawable.setColorFilter(resources.getColor(StringGeneratorHelper.getCardColorId(valueR, requireContext())), PorterDuff.Mode.SRC_ATOP)
    }


}