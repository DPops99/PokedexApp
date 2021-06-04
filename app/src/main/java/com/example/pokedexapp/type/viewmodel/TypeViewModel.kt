package com.example.pokedexapp.type.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.network.model.Types
import com.example.pokedexapp.network.repository.Repository
import kotlinx.coroutines.launch

class TypeViewModel : ViewModel() {

    var api_types = MutableLiveData<Types>()

    init {
        Log.d("DANIJEL_TYPE",api_types.value.toString())
    }

    fun getTypes(type_name : String){
        viewModelScope.launch {
            api_types.value = Repository().getTypes(type_name)
        }
    }
}