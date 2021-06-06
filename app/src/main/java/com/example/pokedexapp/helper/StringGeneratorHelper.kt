package com.example.pokedexapp.helper

import android.content.Context
import android.util.Log
import com.example.pokedexapp.R
import com.example.pokedexapp.network.model.Pokemon
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ceil
import kotlin.math.floor

object StringGeneratorHelper {

    val basic_color_string = "@color/flat_pokemon_type_"
    val basic_color_stats_string = "@color/flat_base_stats_"
    val basic_image_file = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"
    val basic_card_color = "@color/"


    fun getImageFile(pokemon : Pokemon):String{
        Log.d("DANIJEL_IMG", basic_image_file.plus(pokemon.id).plus(".png"))
         return basic_image_file.plus(pokemon.id).plus(".png")
    }

    fun getColorId(value : String, context: Context):Int{
        Log.d("DANIJEL_COLOR_ID",context.resources.getIdentifier(basic_color_string.plus(value), null, context.packageName).toString())
        return  context.resources.getIdentifier(basic_color_string.plus(value), null, context.packageName)
    }

    fun getCardColorId(value: String, context: Context):Int{
        return context.resources.getIdentifier(basic_card_color.plus(value), null, context.packageName)
    }

    fun getColorStatsId(value: String, context: Context):Int{
        var final_value = basic_color_stats_string
        when(value){
            context.getString(R.string.hp) -> final_value = final_value.plus("01_hp")
            context.getString(R.string.defence)-> final_value = final_value.plus("03_defense")
            context.getString(R.string.attack)-> final_value = final_value.plus("02_attack")
            context.getString(R.string.sp_atc)-> final_value = final_value.plus("04_sp_atk")
            context.getString(R.string.sp_def)-> final_value = final_value.plus("05_sp_def")
            context.getString(R.string.speed)-> final_value = final_value.plus("06_speed")
            else -> final_value.plus("01_hp")
        }

        if (final_value == basic_color_string)
            final_value = final_value.plus("01_hp")
        Log.d("DANIJEL_COLOR_STAT",final_value)

        return  context.resources.getIdentifier(final_value, null, context.packageName)
    }

    fun getCorrectIndexRep(value: String):String{
        var basic_index = ""
        if (value.length < 3) {
            for (i in 3-value.length downTo 1) {
                basic_index = basic_index.plus("0")
            }
        }
        basic_index = basic_index.plus(value)
        return basic_index
    }

    fun getWeight(value: Int):String{
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.FLOOR
        val kg = value/10.0

        val lbs = kg*2.2046
        return df.format(lbs).replace(",",".").plus(" lbs (").plus(kg.toString()).plus("kg)")
    }

    fun getHeight(value: Int):String{
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.FLOOR
        var meters = value/10.0
        var inches_t = meters/0.0254
        var feet = floor(inches_t/12).toInt()
        val inches = ceil(inches_t - 12*feet).toInt()

        return feet.toString().plus("'").plus(inches.toString()).plus(Typography.quote).plus(" (").plus(meters.toString()).plus(" m)")
    }
}