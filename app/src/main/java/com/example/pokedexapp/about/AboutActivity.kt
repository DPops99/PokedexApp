package com.example.pokedexapp.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

   private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        setView()
    }

    fun setView(){
        setSupportActionBar(binding.aboutToolbar)

        supportActionBar?.apply {
            title = ""
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.aboutApp.amTitle.text = getString(R.string.about_name)
        binding.aboutApp.amValue.text = getString(R.string.app_name)

        binding.aboutApi.amTitle.text = getString(R.string.abour_api)
        binding.aboutApi.amValue.text = getString(R.string.api_credit)

        binding.aboutDev.amTitle.text = getString(R.string.developer)
        binding.aboutDev.amValue.text = getString(R.string.dev_name)
    }
}