package com.example.pokedexapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.ActivityMainBinding
import com.example.pokedexapp.main.ui.FavoriteFragment
import com.example.pokedexapp.main.ui.SearchFragment
import com.example.pokedexapp.main.ui.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners();
    }


    fun setListeners(){

        binding.navMenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.search_menu -> setCurrentFragment(SearchFragment())
                R.id.fav_menu -> setCurrentFragment(FavoriteFragment())
                R.id.settings_menu -> setCurrentFragment(SettingsFragment())
            }
            true
        }
    }

    fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentView.id,fragment)
            commit()
        }
    }
}