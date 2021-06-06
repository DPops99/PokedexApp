package com.example.pokedexapp.network.model

import java.util.jar.Attributes

data class Move (
        var id : Int,
        var name: String,
        var pp: Int,
        var power: Int,
        var generation : NamedApiResource
        )
