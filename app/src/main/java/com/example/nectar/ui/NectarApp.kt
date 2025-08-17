package com.example.nectar.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductCard
import com.example.nectar.ui.navigation.Account
import com.example.nectar.ui.navigation.AppNavHost
import com.example.nectar.ui.navigation.BottomNavigationBar
import com.example.nectar.ui.navigation.Cart
import com.example.nectar.ui.navigation.Explore
import com.example.nectar.ui.navigation.Favourite
import com.example.nectar.ui.navigation.Onboarding
import com.example.nectar.ui.navigation.Shop
import com.example.nectar.ui.screens.ProductDetail.ProductDetailTopBar
import com.example.nectar.ui.screens.cart.CartTopBar
import com.example.nectar.ui.screens.home.HomeScreen
import com.example.nectar.ui.screens.home.HomeScreenAppBar
import com.example.nectar.ui.screens.home.HomeViewModel
import com.example.nectar.ui.theme.NectarTheme
import kotlinx.serialization.Serializable

@Composable
fun NectarApp(viewModel: HomeViewModel) {
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
            floatingActionButton = {
                /* TODO: Add FloatingActionButton here if needed */
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                AppNavHost(navController = navController , contentPadding = innerPadding , viewModel = viewModel)
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