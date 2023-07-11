package com.example.magiccoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                    startDestination = "MenuScreen",
                ) {
                    composable("FirstScreen") {
                        FirstScreen() {
                            //Thread.sleep(700)
                            navController.navigate("MenuScreen"){ popUpTo("FirstScreen") }
                        }
                    }
                    composable("MenuScreen") {
                        MenuScreen(navController = navController)
                    }
                    composable("OrderScreen/{item}/{cost}/{image}",
                    arguments = listOf(navArgument("item"){
                        type = NavType.StringType
                    },
                        navArgument("cost"){
                            type = NavType.FloatType
                        },
                        navArgument("image"){
                            type = NavType.StringType
                        })

                    ){
                        OrderScreen(name = it.arguments?.getString("item"),
                            image = it.arguments?.getString("image"),
                            costCofe = it.arguments?.getFloat("cost")
                        ) {
                            navController.navigate("MenuScreen")
                        }
                    }
                }
            }
        }

    }
}
