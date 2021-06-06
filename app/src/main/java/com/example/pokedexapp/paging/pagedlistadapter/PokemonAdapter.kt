package com.example.pokedexapp.paging.pagedlistadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.PokemonCardLayoutBinding
import com.example.pokedexapp.helper.StringGeneratorHelper
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.network.model.PokemonList

class PokemonAdapter : PagedListAdapter<Pokemon, PokemonAdapter.PokemonHolder>(DiffUtilCallBack()) {


    class PokemonHolder (val binding: PokemonCardLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        return PokemonHolder(PokemonCardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.binding.cardTitle.text = getItem(position)?.name!!
        holder.binding.cardSubtitle.text = getItem(position)?.id.toString()
        holder.binding.cardImg.load(StringGeneratorHelper.getImageFile(getItem(position)!!))

        holder.binding.cardIcon.apply {
            if (getItem(position)?.isFavorite!!)
                load(R.drawable.ic_star_0)
            else
                load(R.drawable.ic_star_1)


        }
    }
}

class DiffUtilCallBack : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name

    }

}