package com.example.nectar.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(navController: NavHostController) {

    var isOnboardingCompleted by remember { mutableStateOf(false) }

    NavHost(navController = navController, startDestination = Splash) {

        composable<Splash>{}
        composable<Onboarding>{}
        composable<Home>{}
        composable<Product>{}
        composable<Explore>{}
        composable<Cart>{}
        composable<Order>{}


    }
}