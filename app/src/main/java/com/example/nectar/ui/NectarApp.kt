package com.example.nectar.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nectar.ui.navigation.Account
import com.example.nectar.ui.navigation.AppNavHost
import com.example.nectar.ui.navigation.BottomNavigationBar
import com.example.nectar.ui.navigation.Cart
import com.example.nectar.ui.navigation.Explore
import com.example.nectar.ui.navigation.Favourite
import com.example.nectar.ui.navigation.NavHostViewModel
import com.example.nectar.ui.navigation.Onboarding
import com.example.nectar.ui.navigation.Shop
import com.example.nectar.ui.screens.cart.CartTopBar
import com.example.nectar.ui.screens.home.HomeScreenAppBar
import com.example.nectar.ui.screens.home.HomeViewModel
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun NectarApp(viewModel: HomeViewModel, navHostViewModel: NavHostViewModel, startDestination: Any) {
    val navController = rememberNavController()
    val routeToScreen = mapOf(
        Shop::class.qualifiedName to Shop,
        Explore::class.qualifiedName to Explore,
        Cart::class.qualifiedName to Cart,
        Favourite::class.qualifiedName to Favourite,
        Account::class.qualifiedName to Account,
        Onboarding::class.qualifiedName to Onboarding
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentScreen = routeToScreen[currentRoute]

    NectarTheme {
        Scaffold(
            topBar = {
                when (currentScreen) {
                    Shop -> HomeScreenAppBar()
                    Cart -> CartTopBar()
                    else -> {}
                }
            },
            bottomBar = { BottomNavigationBar(navController = navController) },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                AppNavHost(navController = navController , contentPadding = innerPadding , viewModel = viewModel, navHostViewModel = navHostViewModel,
                    startDestination = startDestination)
            }
        }
    }
}


@Preview
@Composable
fun NectarAppPreview() {
    NectarTheme {
//        NectarApp()
    }
}