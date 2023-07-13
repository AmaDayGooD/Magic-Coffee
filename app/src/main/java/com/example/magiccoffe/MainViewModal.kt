package com.example.magiccoffe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.magiccoffe.roomDB.DataBase
import com.example.magiccoffe.roomDB.Users
import kotlinx.coroutines.launch

class MainViewModal(val database: DataBase) : ViewModel() {

    val itemlist = database.dao.getAll()
    val estList = database.dao.getAllEst()

    val newItemUser: Users?=null

    fun insertUser(newItemUser:Users?) = viewModelScope.launch {
        database.dao.setUser(newItemUser!!)
    }

    companion object{
        val factory: ViewModelProvider.Factory = object: ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).dataBase
                return MainViewModal(database) as T
            }
        }
    }

}

