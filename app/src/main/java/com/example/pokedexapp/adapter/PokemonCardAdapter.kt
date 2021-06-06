package com.example.pokedexapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.PokemonCardLayoutBinding
import com.example.pokedexapp.helper.StringGeneratorHelper
import com.example.pokedexapp.network.model.Pokemon

class PokemonCardAdapter(var pokemons : ArrayList<Pokemon>, val context: Context, val listener : PokemonCardAdapter.OnItemClickListener, val fav_listener : PokemonCardAdapter.OnFavClickListener?) : RecyclerView.Adapter<PokemonCardAdapter.PokemonViewHolder>(){



    inner class PokemonViewHolder(val binding: PokemonCardLayoutBinding) : RecyclerView.ViewHolder(binding.root),View.OnClickListener{

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(PokemonCardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.binding.cardTitle.text = pokemons[position].name.capitalize()
        holder.binding.cardSubtitle.text = StringGeneratorHelper.getCorrectIndexRep(pokemons[position].id.toString())
        holder.binding.cardImg.load(StringGeneratorHelper.getImageFile(pokemons[position]))

        holder.binding.cardIcon.apply {
            if (pokemons[position].isFavorite)
                load(R.drawable.ic_star_0)
            else
                load(R.drawable.ic_star_1)

            fav_listener?.let {
                setOnClickListener {
                    if (pokemons[position].isFavorite)
                        fav_listener.onClick(position, false)
                    else
                        fav_listener.onClick(position, true)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    interface OnItemClickListener{
        fun onClick(position : Int)
    }

    interface OnFavClickListener{
        fun onClick(position: Int, isFav : Boolean)
    }

    fun moveItem(from : Int, to: Int){
        val from_pokemon = pokemons[from]
        val from_order = pokemons[from].order
        val to_order = pokemons[to].order

        pokemons[from].order = to_order
        pokemons[to].order = from_order

        pokemons[from] = pokemons[to]
        pokemons[to] = from_pokemon
    }
}