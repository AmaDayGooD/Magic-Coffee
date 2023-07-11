package com.example.magiccoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.magiccoffe.ui.theme.MagicCoffeTheme
import com.example.magiccoffe.ui.theme.screens.FirstScreen
import com.example.magiccoffe.ui.theme.screens.MenuScreen
import com.example.magiccoffe.ui.theme.screens.OrderScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //OrderScreen()

            val navController = rememberNavController()

            MagicCoffeTheme {
                NavHost(
                    navController = navController,
                    startDestination = "OrderScreen",
                ) {
                    composable("FirstScreen") {
                        FirstScreen() {
                            //Thread.sleep(700)
                            navController.navigate("MenuScreen"){ popUpTo("FirstScreen") }
                        }
                    }
                    composable("MenuScreen") {
                        MenuScreen(){
                            navController.navigate("OrderScreen")
                        }
                    }
                    composable("OrderScreen"){
                        OrderScreen {
                            navController.navigate("MenuScreen") { popUpTo("MainScreen")}
                        }
                    }
                }
            }
        }

    }
}
