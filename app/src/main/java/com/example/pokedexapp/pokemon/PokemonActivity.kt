package com.example.pokedexapp.pokemon

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.ActivityPokemonBinding
import com.example.pokedexapp.helper.ImageFileConverterHelper
import com.example.pokedexapp.main.ui.search.SearchFragment
import com.example.pokedexapp.network.model.Pokemon
import com.google.android.material.chip.Chip

class PokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setView()
    }


    fun setView(){

        setSupportActionBar(binding.pokemonToolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }



        intent?.getSerializableExtra(SearchFragment().current_pokemon)?.let {
            val current_pokemon = it as Pokemon
            var total = 0

            binding.pokemonName.text = current_pokemon.name
            binding.pokemonNum.text = current_pokemon.id.toString()
            binding.pokemonImg.load(ImageFileConverterHelper.getImageFile(current_pokemon))
            binding.pokemonFav.load(R.drawable.ic_star_1)

            for (item_type in current_pokemon.types){
                var chip = Chip(this)
                chip.text = item_type.type.name
                binding.pokemonChipGroup.addView(chip)
            }

            binding.pokemonHeight.itemImg.load(R.drawable.ic_baseline_height_24)
            binding.pokemonHeight.itemDesc.text = getString(R.string.height)
            binding.pokemonHeight.itemValue.text = current_pokemon.height.toString()

            binding.pokemonWeight.itemImg.load(R.drawable.ic_weight)
            binding.pokemonWeight.itemDesc.text = getString(R.string.weight)
            binding.pokemonWeight.itemValue.text = current_pokemon.weight.toString()


            binding.abilityOne.text = current_pokemon.abilities[0].ability.name
            binding.abilityTwo.text = current_pokemon.abilities[1].ability.name



            binding.hp.itemDesc2.text = getString(R.string.hp)
            binding.hp.itemValue2.text = current_pokemon.stats[0].base_stat.toString()
            binding.hp.itemProgress.max = 100
            binding.hp.itemProgress.progress = current_pokemon.stats[0].base_stat
            total += current_pokemon.stats[0].base_stat

            binding.attack.itemDesc2.text = getString(R.string.attack)
            binding.attack.itemValue2.text = current_pokemon.stats[1].base_stat.toString()
            binding.attack.itemProgress.max = 100
            binding.attack.itemProgress.progress = current_pokemon.stats[1].base_stat
            total += current_pokemon.stats[1].base_stat

            binding.defence.itemDesc2.text = getString(R.string.defence)
            binding.defence.itemValue2.text = current_pokemon.stats[2].base_stat.toString()
            binding.defence.itemProgress.max = 100
            binding.defence.itemProgress.progress = current_pokemon.stats[2].base_stat
            total += current_pokemon.stats[2].base_stat

            binding.spAtc.itemDesc2.text = getString(R.string.sp_atc)
            binding.spAtc.itemValue2.text = current_pokemon.stats[3].base_stat.toString()
            binding.spAtc.itemProgress.max = 100
            binding.spAtc.itemProgress.progress = current_pokemon.stats[3].base_stat
            total += current_pokemon.stats[3].base_stat

            binding.spDef.itemDesc2.text = getString(R.string.sp_def)
            binding.spDef.itemValue2.text = current_pokemon.stats[4].base_stat.toString()
            binding.spDef.itemProgress.max = 100
            binding.spDef.itemProgress.progress = current_pokemon.stats[4].base_stat
            total += current_pokemon.stats[4].base_stat

            binding.speed.itemDesc2.text = getString(R.string.speed)
            binding.speed.itemValue2.text = current_pokemon.stats[5].base_stat.toString()
            binding.speed.itemProgress.max = 100
            binding.speed.itemProgress.progress = current_pokemon.stats[5].base_stat
            total += current_pokemon.stats[5].base_stat

            var progressDrawable :Drawable = binding.speed.itemProgress.progressDrawable.mutate()
            progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_ATOP)
            binding.speed.itemProgress.progressDrawable = progressDrawable
//            binding.speed.itemProgress.progress = current_pokemon.stats[5].base_stat



            binding.total.itemDesc2.text = getString(R.string.total)
            binding.total.itemValue2.text = total.toString()
            binding.total.itemProgress.visibility = View.INVISIBLE


        }
    }
}