package com.example.nectar.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductCard
import com.example.nectar.ui.navigation.AppNavHost
import com.example.nectar.ui.screens.home.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun NectarApp() {

    val navController = rememberNavController()
    AppNavHost(navController = navController)

    HomeScreen()

}

