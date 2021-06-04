package com.example.pokedexapp.network.model

data class Types (
        var id : Int,
        var name : String,
        var damage_relations : TypeRelations
        )

data class TypeRelations(
        var no_damage_to : List<NamedApiResource>,
        var half_damage_to : List<NamedApiResource>,
        var double_damage_to : List<NamedApiResource>,
        var no_damage_from : List<NamedApiResource>,
        var half_damage_from : List<NamedApiResource>,
        var double_damage_from : List<NamedApiResource>
)