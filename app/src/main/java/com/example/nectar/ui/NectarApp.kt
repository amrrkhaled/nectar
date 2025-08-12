package com.example.nectar.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductCard
import com.example.nectar.ui.navigation.AppNavHost
import com.example.nectar.ui.navigation.BottomNavigationBar
import com.example.nectar.ui.screens.home.HomeScreen
import com.example.nectar.ui.theme.NectarTheme
import kotlinx.serialization.Serializable

@Composable
fun NectarApp() {
    val navController = rememberNavController()

    NectarTheme {
        Scaffold(
            topBar = { /* TODO: Add your TopAppBar if any */ },
            bottomBar = { BottomNavigationBar(navController = navController) },
            floatingActionButton = {
                /* TODO: Add FloatingActionButton here if needed */
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                AppNavHost(navController = navController)
            }
        }
    }
}


@Preview
@Composable
fun NectarAppPreview() {
    NectarTheme {
        NectarApp()
    }
}