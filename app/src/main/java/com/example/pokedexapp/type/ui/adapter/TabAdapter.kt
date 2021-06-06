package com.example.pokedexapp.type.ui.adapter

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pokedexapp.R
import com.example.pokedexapp.type.ui.damage.DamageFragment
import com.example.pokedexapp.type.ui.moves.MovesFragment
import com.example.pokedexapp.type.ui.pokemons.PokemonsFragment


internal class TabAdapter(
        var context: Context,
        fm: FragmentManager,
        var tabNum: Int
) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return tabNum
    }

    override fun getPageTitle(position: Int): CharSequence? {
         when(position){
            0 -> {
                return context.resources.getString(R.string.damage_overview)
            }
            1 -> {
                return context.resources.getString(R.string.moves)
            }
            2 -> {
                return context.resources.getString(R.string.pokemons)
            }
            else -> return getPageTitle(position)
        }
    }

    override fun getItem(position: Int): Fragment {
         when(position){
            0 -> {
                Log.d("DANIJEL_TABS2",position.toString())
                return DamageFragment()
            }
            1 -> {
                Log.d("DANIJEL_TABS2",position.toString())
                return MovesFragment()
            }
            2 -> {
                Log.d("DANIJEL_TABS2",position.toString())
                return PokemonsFragment()
            }
            else -> { return getItem(position)}
        }
    }

}