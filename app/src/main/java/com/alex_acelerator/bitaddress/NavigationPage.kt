package com.alex_acelerator.bitaddress

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnrememberedMutableState")
@Composable
fun NavController(

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
            val checked = mutableStateOf(true)
            SimpleGenerationPage(
                navController
            )
        }
    }
}
