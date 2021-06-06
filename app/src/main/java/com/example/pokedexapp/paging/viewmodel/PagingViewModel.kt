package com.example.pokedexapp.paging.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.pokedexapp.network.model.Pokemon
import com.example.pokedexapp.paging.datasource.PokemonDataSource
import com.example.pokedexapp.room.database.AppDatabase

class PagingViewModel(context: Context) : ViewModel() {

//    var postsLiveData :LiveData<PagedList<Pokemon>>
//
//    init {
//        val config = PagedList.Config.Builder()
//            .setPageSize(20)
//            .setEnablePlaceholders(false)
//            .build()
//        postsLiveData  = initializedPagedListBuilder(config).build()
//    }
//
//
//
//    private fun initializedPagedListBuilder(config: PagedList.Config):
//            LivePagedListBuilder<Int, Pokemon> {
//
//        val dataSourceFactory = object : DataSource.Factory<Int, Pokemon>() {
//            override fun create(): DataSource<Int, Pokemon> {
//                return PokemonDataSource(viewModelScope, AppDatabase.getInstance(context)!!)
//            }
//        }
//        return LivePagedListBuilder<Int, Pokemon>(dataSourceFactory, config)
//    }
}