package com.example.magiccoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.magiccoffe.screens.OrderScreen
import com.example.magiccoffe.ui.theme.MagicCoffeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagicCoffeTheme {
                OrderScreen()
                //MainScreen()
            }
        }
    }
}
