package com.example.pokedexapp.room.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class RoomFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(RoomViewModel::class.java))
            return RoomViewModel(context) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}