package com.example.pokedexapp.network.model

data class Pokemon (
    var id : Int,
    var name : String,
    var height : Int,
    var abilities : List<PokemonAbility>,
    var stats : List<PokemonStat>,
    @Transient
    var img_url : String?,
    var types : List<PokemonType>,
//    var species : List<PokemonSpecies_NAR>
        )
