package com.example.nectar.ui.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.ui.screens.cart.CartScreen
import com.example.nectar.ui.screens.explore.ExploreScreen
import com.example.nectar.ui.screens.home.HomeScreen
import com.example.nectar.ui.screens.onboarding.OnboardingScreen
import com.example.nectar.ui.screens.order.OrderScreen
import com.example.nectar.ui.screens.splash.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavHost(
    navController: NavHostController,
    // Consider injecting a preferences repository here
//    onboardingViewModel: OnboardingViewModel = hiltViewModel()
) {
//    val isOnboardingCompleted by onboardingViewModel.isOnboardingCompleted.collectAsState()
    val isOnboardingCompleted = true
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashScreen()

            LaunchedEffect(Unit) {
                delay(2000)
                val destination = if (isOnboardingCompleted) Shop else Onboarding
                navController.navigate(destination) {
                    popUpTo(Splash) { inclusive = true }
                }
            }
        }

        composable<Onboarding> {
            OnboardingScreen(
//                onComplete = {
//                    onboardingViewModel.completeOnboarding()
//                    navController.navigate(Shop) {
//                        popUpTo(Onboarding) { inclusive = true }
//                    }
//                }
            )
        }

        composable<Shop> {
            HomeScreen(
//                onProductClick = { productId ->
//                    navController.navigate(Product(id = productId))
//                }
            )
        }

        composable<Product> { backStackEntry ->
            val product = backStackEntry.toRoute<Product>()
//            ProductScreen(
//                productId = product.id,
//                onBackClick = { navController.popBackStack() },
//                onAddToCart = { productId ->
//                    // Handle add to cart and potentially navigate to cart
//                    navController.navigate(Cart)
//                }
//            )
        }

        composable<Explore> {
            ExploreScreen()
        }

        composable<Cart> {
            CartScreen(
//                onCheckout = {
//                    navController.navigate(Order)
//                }
            )
        }

        composable<Favourite> {
//            FavouriteScreen()
        }

        composable<Account> {
//            AccountScreen(
//                onOrdersClick = {
//                    navController.navigate(Order)
//                }
//            )
        }

        composable<Order> {
            OrderScreen(
//                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
