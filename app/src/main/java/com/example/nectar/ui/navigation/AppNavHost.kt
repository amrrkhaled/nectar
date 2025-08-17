package com.example.nectar.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.data.prefrences.OnboardingPreferences
import com.example.nectar.ui.screens.ProductDetail.ProductDetailScreen
import com.example.nectar.ui.screens.ProductDetail.ProductDetailViewModel
import com.example.nectar.ui.screens.cart.CartScreen
import com.example.nectar.ui.screens.explore.ExploreScreen
import com.example.nectar.ui.screens.favorite.FavoriteScreen
import com.example.nectar.ui.screens.home.HomeScreen
import com.example.nectar.ui.screens.home.HomeViewModel
import com.example.nectar.ui.screens.onboarding.OnboardingScreen
import com.example.nectar.ui.screens.order.OrderScreen
import com.example.nectar.ui.screens.splash.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavHost(
    contentPadding: PaddingValues = PaddingValues(0.dp),
    navController: NavHostController,
    viewModel: HomeViewModel,
//    navHostViewModel: NavHostViewModel = hiltViewModel()
) {
//    val isOnboardingCompleted by navHostViewModel.onboardingPreferences
//        .isOnboardingCompleted
//        .collectAsState(initial = false)
//    val startDestination = if (isOnboardingCompleted) Shop else Onboarding

    NavHost(
        navController = navController,
        startDestination = Onboarding
    ) {

        composable<Onboarding> {
            OnboardingScreen(
                onGetStarted = {
                    navController.navigate(Shop) {
                        popUpTo(Onboarding) { inclusive = true }
                    }
                }
            )
        }

        composable<Shop> {
            HomeScreen(
                modifier = Modifier.padding(contentPadding),
                onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                },
                viewModel = viewModel
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
