package com.example.nectar.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.ui.navigation.AppNavHost
import kotlinx.serialization.Serializable

@Composable
fun NectarApp() {

    val navController = rememberNavController()
    AppNavHost(navController = navController)

}

