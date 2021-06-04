package com.example.pokedexapp.type.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pokedexapp.type.ui.damage.DamageFragment
import com.example.pokedexapp.type.ui.moves.MovesFragment
import com.example.pokedexapp.type.ui.pokemons.PokemonsFragment

class TabAdapter(
        var context: Context,
        fm: FragmentManager,
        var tabNum: Int
) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return tabNum
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> DamageFragment()
            1-> MovesFragment()
            2 -> PokemonsFragment()
            else -> DamageFragment()
        }
    }

}