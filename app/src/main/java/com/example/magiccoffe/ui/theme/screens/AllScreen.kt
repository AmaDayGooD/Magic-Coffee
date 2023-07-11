package com.example.magiccoffe.ui.theme.screens

sealed class AllScreen(val route :String) {
    object OrderScreen : AllScreen("OrderScreen")
    object MenuScreen : AllScreen("MenuScreen")
    object FirstScreen : AllScreen("FirstScreen")
}