package com.example.magiccoffe

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.magiccoffe.ui.theme.screens.*
import com.example.magiccoffe.ui.theme.screens.ui.theme.MagicCoffeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val permissions = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            ActivityCompat.requestPermissions(this, permissions, 0)
        }

        setContent {
            //OnBoardScreen()

            val navController = rememberNavController()
            //Authorization(navController)

            MagicCoffeTheme {
                NavHost(
                    navController = navController,
                    startDestination = "OnBoardScreen",
                ) {
                    composable("FirstScreen") {
                        FirstScreen() {
                            //Thread.sleep(700)
                            navController.navigate("MenuScreen") { popUpTo("FirstScreen") }
                        }
                    }

                    composable(
                        "MenuScreen/{id}",
                        arguments = listOf(navArgument("id") {
                            type = NavType.IntType
                        })
                    ) {
                        MenuScreen(
                            navController = navController,
                            cafeID = it.arguments?.getInt("id")
                        )
                    }

                    composable(
                        "OrderScreen/{item}/{cost}/{image}/{idCafe}",
                        arguments = listOf(navArgument("item") {
                            type = NavType.StringType
                        },
                            navArgument("cost") {
                                type = NavType.FloatType
                            },
                            navArgument("image") {
                                type = NavType.StringType
                            },
                            navArgument("idCafe") {
                                type = NavType.IntType
                            })

                    ) {
                        OrderScreen(
                            navController = navController,
                            name = it.arguments?.getString("item"),
                            image = it.arguments?.getString("image"),
                            costCofe = it.arguments?.getFloat("cost"),
                            idCafe = it.arguments?.getInt("idCafe")
                        )
                    }

                    composable("MapScreen") {
                        MapScreen(navController = navController)
                    }
                    composable("OnBoardScreen") {
                        OnBoardScreen(navController = navController)
                    }
                    composable("Authorization") {
                        Authorization(navController = navController)
                    }
                    composable("Registration"){
                        Registration(navController = navController)
                    }
                }
            }
        }
    }
}


