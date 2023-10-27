package com.alex_acelerator.bitaddress

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationHost(

) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "MainPage",
    ) {
        composable(route = "MainPage") {
            MainPage(
                navController
            )
        }
        composable(route = "SimpleGenerationPage"){
            SimpleGenerationPage(
                navController
            )
        }
    }
}
