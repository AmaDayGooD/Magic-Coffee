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
import com.example.magiccoffe.ui.theme.screens.itemLazyColumn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //MenuScreen()

            val navController = rememberNavController()

            MagicCoffeTheme {
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
                            navController.navigate("MenuScreen")
                        }
                    }
                    composable("MenuScreen") {
                        itemLazyColumn(onClick = {
                            navController.navigate("OrderScreen") {

                            }
                        }
                        )
                    }
                }
            }
        }
    }
}
