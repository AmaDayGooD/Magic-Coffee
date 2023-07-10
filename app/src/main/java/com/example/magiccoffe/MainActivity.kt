package com.example.magiccoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.magiccoffe.ui.theme.MagicCoffeTheme
import com.example.magiccoffe.ui.theme.screens.MenuCafeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuCafeScreen()
            //val navController = rememberNavController()

            MagicCoffeTheme {
                /*
                NavHost(
                    navController = navController,
                    startDestination = "FirstScreen"
                ) {
                    composable("OrderScreen") {
                        OrderScreen {
                            navController.navigate("FirstScreen")
                            { popUpTo("MainScreen") }
                        }

                    }
                    composable("FirstScreen") {
                        FirstScreen() {
                            Thread.sleep(700)
                            navController.navigate("OrderScreen")
                        }
                    }
                    composable("MenuCafeScreen") {
                        MenuCafeScreen {
                            navController.navigate("OrderScreen") {

                            }
                        }
                    }
                }*/
            }
        }
    }
}