package com.example.pokedexapp.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedexapp.databinding.PokemonCardRecyclerViewBinding
import com.example.pokedexapp.helper.StringGeneratorHelper
import com.example.pokedexapp.network.model.Pokemon

class EvolutionAdapter(var chains : List<Pokemon>, var context: Context) : RecyclerView.Adapter<EvolutionAdapter.EvolutionHolder>(){

    inner class EvolutionHolder(val binding: PokemonCardRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionHolder {
        return EvolutionHolder(PokemonCardRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: EvolutionHolder, position: Int) {
        holder.binding.pokemonCardImg.load(StringGeneratorHelper.getImageFile(chains[position]))
        holder.binding.pokemonCardName.text = chains[position].name
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