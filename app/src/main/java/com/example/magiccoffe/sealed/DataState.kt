package com.example.magiccoffe.sealed

import com.example.magiccoffe.models.coffeeGet

sealed class DataState4 {
    class Success(val data:MutableList<coffeeGet>): DataState4()
    class Failure(val message: String): DataState4()
    object Loading : DataState4()
    object Empty :  DataState4()
}