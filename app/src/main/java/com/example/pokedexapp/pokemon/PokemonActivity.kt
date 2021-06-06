package com.example.pokedexapp.pokemon

import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.pokedexapp.R
import com.example.pokedexapp.databinding.ActivityPokemonBinding
import com.example.pokedexapp.helper.StringGeneratorHelper
import com.example.pokedexapp.main.ui.search.SearchFragment
import com.example.pokedexapp.main.viewmodels.ApiViewModel
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.pokemon.adapter.EvolutionAdapter
import com.example.pokedexapp.type.PokemonTypeActivity
import com.google.android.material.chip.Chip

import com.google.android.material.resources.TextAppearance

class PokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonBinding
    private lateinit var adapter: EvolutionAdapter
//    private val typeViewModel: TypeViewModel by viewModels()
    val current_type = "CURRENT_TYPE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityPokemonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setView()
    }


    fun setView(){

        setSupportActionBar(binding.pokemonToolbar)
        val pokemonModel : ApiViewModel by viewModels()

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }



        intent?.getSerializableExtra("CURRENT_POKEMON")?.let {
            val current_pokemon = it as Pokemon
            var total = 0



            binding.pokemonName.text = current_pokemon.name.capitalize()
            binding.pokemonNum.text = StringGeneratorHelper.getCorrectIndexRep(current_pokemon.id.toString())
            binding.pokemonImg.load(StringGeneratorHelper.getImageFile(current_pokemon))
            Log.d("DANIJEL",current_pokemon.isFavorite.toString())
            if (current_pokemon.isFavorite)
                binding.pokemonFav.load(R.drawable.ic_star_0)
            else
                binding.pokemonFav.load(R.drawable.ic_star_1)

            for (item_type in current_pokemon.types){
                var chip = Chip(this)
                chip.setChipBackgroundColorResource(StringGeneratorHelper.getColorId(item_type.type.name, applicationContext))
                chip.text = item_type.type.name.capitalize()
                chip.textSize = 14.0F

                chip.setTextColor(resources.getColor(R.color.surface_1))
                chip.setOnClickListener {
                    getTypes(chip.text.toString().decapitalize())

                }
                binding.pokemonChipGroup.addView(chip)
            }

            binding.pokemonHeight.itemImg.load(R.drawable.ic_baseline_height_24)
            binding.pokemonHeight.itemDesc.text = getString(R.string.height)
            binding.pokemonHeight.itemValue.text = StringGeneratorHelper.getHeight(current_pokemon.height)

            binding.pokemonWeight.itemImg.load(R.drawable.ic_weight)
            binding.pokemonWeight.itemDesc.text = getString(R.string.weight)
            binding.pokemonWeight.itemValue.text = StringGeneratorHelper.getWeight(current_pokemon.weight)


            binding.abilityOne.text = current_pokemon.abilities[0].ability.name.capitalize()
            binding.abilityTwo.text = current_pokemon.abilities[1].ability.name.capitalize()



            binding.hp.itemDesc2.text = getString(R.string.hp)
            binding.hp.itemValue2.text = current_pokemon.stats[0].base_stat.toString()
            binding.hp.itemProgress.max = 100
            binding.hp.itemProgress.progress = current_pokemon.stats[0].base_stat
            setProgressBarColor(binding.hp.itemProgress.progressDrawable as LayerDrawable, getString(R.string.hp))
            total += current_pokemon.stats[0].base_stat

            binding.attack.itemDesc2.text = getString(R.string.attack)
            binding.attack.itemValue2.text = current_pokemon.stats[1].base_stat.toString()
            binding.attack.itemProgress.max = 100
            binding.attack.itemProgress.progress = current_pokemon.stats[1].base_stat
            setProgressBarColor(binding.attack.itemProgress.progressDrawable as LayerDrawable, getString(R.string.attack))
            total += current_pokemon.stats[1].base_stat

            binding.defence.itemDesc2.text = getString(R.string.defence)
            binding.defence.itemValue2.text = current_pokemon.stats[2].base_stat.toString()
            binding.defence.itemProgress.max = 100
            binding.defence.itemProgress.progress = current_pokemon.stats[2].base_stat
            setProgressBarColor(binding.defence.itemProgress.progressDrawable as LayerDrawable, getString(R.string.defence))
            total += current_pokemon.stats[2].base_stat

            binding.spAtc.itemDesc2.text = getString(R.string.sp_atc)
            binding.spAtc.itemValue2.text = current_pokemon.stats[3].base_stat.toString()
            binding.spAtc.itemProgress.max = 100
            binding.spAtc.itemProgress.progress = current_pokemon.stats[3].base_stat
            setProgressBarColor(binding.spAtc.itemProgress.progressDrawable as LayerDrawable, getString(R.string.sp_atc))
            total += current_pokemon.stats[3].base_stat

            binding.spDef.itemDesc2.text = getString(R.string.sp_def)
            binding.spDef.itemValue2.text = current_pokemon.stats[4].base_stat.toString()
            binding.spDef.itemProgress.max = 100
            binding.spDef.itemProgress.progress = current_pokemon.stats[4].base_stat
            setProgressBarColor(binding.spDef.itemProgress.progressDrawable as LayerDrawable, getString(R.string.sp_def))
            total += current_pokemon.stats[4].base_stat

            binding.speed.itemDesc2.text = getString(R.string.speed)
            binding.speed.itemValue2.text = current_pokemon.stats[5].base_stat.toString()
            binding.speed.itemProgress.max = 100
            binding.speed.itemProgress.progress = current_pokemon.stats[5].base_stat
            setProgressBarColor(binding.speed.itemProgress.progressDrawable as LayerDrawable, getString(R.string.speed))
            total += current_pokemon.stats[5].base_stat

//            val layerDrawable = binding.speed.itemProgress.progressDrawable as LayerDrawable
//            val progressDrawable :Drawable = layerDrawable.findDrawableByLayerId(android.R.id.progress)
//            progressDrawable.setColorFilter(resources.getColor(R.color.flat_base_stats_06_speed), PorterDuff.Mode.SRC_ATOP)




            binding.total.itemDesc2.text = getString(R.string.total)
            binding.total.itemDesc2.setTextColor(resources.getColor(R.color.cold_gray))
            binding.total.itemValue2.text = total.toString()
            binding.total.itemValue2.setTextColor(resources.getColor(R.color.cold_gray))
            binding.total.itemProgress.visibility = View.INVISIBLE


            binding.pokemonRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            adapter = EvolutionAdapter(ArrayList<Pokemon>() ,applicationContext, current_pokemon.id)
            binding.pokemonRv.adapter = adapter

            pokemonModel.apiEvolutionChain.observe(this, Observer {
                Log.d("DANIJEL_PoK",it.toString())
            })
            pokemonModel.getPokemonSpecies(current_pokemon)
            pokemonModel.apiPokemons.observe(this, Observer {
                adapter.chains = it
                adapter.notifyDataSetChanged()
            })

//            typeViewModel.api_types.observe(this, Observer {
//                Log.d("DANIJEL",it.toString())
//                startActivity(Intent(this, PokemonTypeActivity::class.java))
//            })

        }
    }

    fun getTypes(value: String){
        Log.d("DANIJEL_SENDING",value)
        intent = Intent(this, PokemonTypeActivity::class.java)
        intent.putExtra(current_type, value)
        startActivity(intent)
        finish()
//        typeViewModel.getTypes(value)
    }

    fun setProgressBarColor(layerDrawable: LayerDrawable, value :String){
        val progressDrawable :Drawable = layerDrawable.findDrawableByLayerId(android.R.id.progress)

        progressDrawable.setColorFilter(resources.getColor(StringGeneratorHelper.getColorStatsId(value, applicationContext)), PorterDuff.Mode.SRC_ATOP)
    }

}