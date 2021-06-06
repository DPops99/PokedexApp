package com.example.pokedexapp.type

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.ActivityPokemonTypeBinding
import com.example.pokedexapp.type.ui.adapter.TabAdapter

class PokemonTypeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonTypeBinding
    private lateinit var adapter: TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.typeToolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }


//        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.addTab(binding.tabs.newTab().setText(getString(R.string.damage_overview)))
        binding.tabs.addTab(binding.tabs.newTab().setText(getString(R.string.moves)))
        binding.tabs.addTab(binding.tabs.newTab().setText(getString(R.string.pokemons)))
        binding.tabs.tabGravity = TabLayout.GRAVITY_FILL

        binding.viewPager.adapter = TabAdapter(applicationContext, supportFragmentManager, 3)
//        Log.d("DANIJEL_TABC",binding.tabs.tabCount.toString())
//        adapter = TabAdapter(this, supportFragmentManager, binding.tabs.tabCount)
//        binding.viewPager.adapter = adapter
//        binding.tabs.setupWithViewPager(binding.viewPager)



        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabs))
        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab?.position!!
                Log.d("DANIJEL_TABS",tab?.position!!.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }
}