package com.example.pokedexapp.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.PokemonCardRecyclerViewBinding
import com.example.pokedexapp.helper.StringGeneratorHelper
import com.example.pokedexapp.network.model.Pokemon
import com.google.android.material.chip.Chip

class EvolutionAdapter(var chains : List<Pokemon>, var context: Context, var current_pok_id : Int) : RecyclerView.Adapter<EvolutionAdapter.EvolutionHolder>(){

    inner class EvolutionHolder(val binding: PokemonCardRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionHolder {
        return EvolutionHolder(PokemonCardRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: EvolutionHolder, position: Int) {
        holder.binding.pokemonCardImg.load(StringGeneratorHelper.getImageFile(chains[position]))
        holder.binding.pokemonCardName.text = chains[position].name.capitalize()

        if (current_pok_id != -1) {
            if (current_pok_id == chains[position].id)
                holder.binding.cardPokemonEvol.strokeColor = context.resources.getColor(R.color.cold_gray)
            if (position == 0)
                holder.binding.evoulitonText.text = context.resources.getString(R.string.unevolved)
            else
                holder.binding.evoulitonText.text = position.toString().plus(" ").plus(context.getString(R.string.evolution)).toUpperCase()
        }
        else {
            holder.binding.evoulitonText.visibility = View.INVISIBLE
            holder.binding.cardPokemonEvol.visibility = View.INVISIBLE
        }
//        for (item_type in chains[position].types) {
//            val chip = Chip(context)
//            chip.text = item_type.type.name
//            holder.binding.pokemonTypes.addView(chip)
//        }
    }

    override fun getItemCount(): Int {
        return chains.size
    }
}