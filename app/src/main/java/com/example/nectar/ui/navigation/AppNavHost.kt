package com.example.nectar.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.ui.screens.ProductDetail.ProductDetailScreen
import com.example.nectar.ui.screens.ProductDetail.ProductDetailViewModel
import com.example.nectar.ui.screens.cart.CartScreen
import com.example.nectar.ui.screens.explore.ExploreScreen
import com.example.nectar.ui.screens.favorite.FavoriteScreen
import com.example.nectar.ui.screens.home.HomeScreen
import com.example.nectar.ui.screens.onboarding.OnboardingScreen
import com.example.nectar.ui.screens.order.OrderScreen
import com.example.nectar.ui.screens.splash.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavHost(
    contentPadding : PaddingValues = PaddingValues(0.dp),
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
                modifier = Modifier.padding(contentPadding),
                onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                }
            )
        }
        composable<Product> {
            val viewModel: ProductDetailViewModel = hiltViewModel()
            ProductDetailScreen(
                viewModel = viewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<Explore> {
            ExploreScreen()
        }

        composable<Cart> {
            CartScreen(
                modifier = Modifier.padding(contentPadding),
////                onCheckout = {
////                    navController.navigate(Order)
////                }
                onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                },
                onGoToOrder = {
                    navController.navigate(Order) {
                        popUpTo(Cart) { inclusive = true }
                    }
                }
            )
        }

        composable<Favourite> {
            FavoriteScreen(
                modifier = Modifier.padding(contentPadding),
                onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                }
                )
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
                onBackToHome = {
                    navController.navigate(Shop) {
                        popUpTo(Order) { inclusive = true }
                    }
                }
            )
        }
    }
}
