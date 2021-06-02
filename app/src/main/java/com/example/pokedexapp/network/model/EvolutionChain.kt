package com.example.pokedexapp.network.model

data class EvolutionChain(
        var id:Int,
        var chain: ChainLink
)

data class ChainLink(
        var species: NamedApiResource,
        var evolves_to: List<ChainLink>
)
