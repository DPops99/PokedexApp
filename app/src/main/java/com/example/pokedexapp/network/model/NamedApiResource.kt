package com.example.pokedexapp.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class NamedApiResource (

        var name : String,
        var url : String
        ): Serializable

data class ApiResource(
        var url : String
) : Serializable