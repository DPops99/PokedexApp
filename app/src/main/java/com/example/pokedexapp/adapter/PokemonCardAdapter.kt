package com.example.pokedexapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.PokemonCardLayoutBinding
import com.example.pokedexapp.network.model.Pokemon

class PokemonCardAdapter(var pokemons : ArrayList<Pokemon>, val context: Context) : RecyclerView.Adapter<PokemonCardAdapter.PokemonViewHolder>(){



    inner class PokemonViewHolder(val binding: PokemonCardLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(PokemonCardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.binding.cardTitle.text = pokemons[position].name
        holder.binding.cardSubtitle.text = pokemons[position].id.toString()
        holder.binding.cardImg.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png")
        holder.binding.cardIcon.load(R.drawable.ic_star_1)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}