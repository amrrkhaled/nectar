package com.example.nectar.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.toRoute
import com.example.nectar.ui.screens.ProductDetail.ProductDetailScreen
import com.example.nectar.ui.screens.ProductDetail.ProductDetailViewModel
import com.example.nectar.ui.screens.cart.CartScreen
import com.example.nectar.ui.screens.explore.CategoryScreen
import com.example.nectar.ui.screens.explore.ExploreHomeSharedViewModel
import com.example.nectar.ui.screens.explore.ExploreScreen
import com.example.nectar.ui.screens.explore.ExploreScreenViewModel
import com.example.nectar.ui.screens.explore.FilterScreen
import com.example.nectar.ui.screens.favorite.FavoriteScreen
import com.example.nectar.ui.screens.home.HomeScreen
import com.example.nectar.ui.screens.home.HomeViewModel
import com.example.nectar.ui.screens.onboarding.OnboardingScreen
import com.example.nectar.ui.screens.order.OrderScreen

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
    val isOnboardingCompleted = true
    val startDestination = if (isOnboardingCompleted) Shop else Onboarding
    val exploreHomeViewModel: ExploreHomeSharedViewModel = hiltViewModel()
    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        composable<Onboarding> {
            OnboardingScreen(
                onGetStarted = {
                    navController.navigate(Shop) {
                        popUpTo(Onboarding) { inclusive = true }
                    }
                })
        }

        composable<Shop> {
            HomeScreen(modifier = Modifier.padding(contentPadding), onProductClick = { productId ->
                navController.navigate(Product(id = productId))
            }, viewModel = viewModel, onSearchBarClick = {
                navController.navigate(Explore) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }

            }, sharedViewModel = exploreHomeViewModel,
            )
        }
        composable<Product> {
            val viewModel: ProductDetailViewModel = hiltViewModel()
            ProductDetailScreen(
                viewModel = viewModel, onBack = {
                    navController.popBackStack()
                })
        }
        composable<Explore>(

        ) { backStackEntry ->

            ExploreScreen(
                onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                },
                onFilterClick = {
                    navController.navigate(Filter)
                },
                onCategoryClick = { categoryName ->
                    navController.navigate(Category(name = categoryName))
                },
                sharedViewModel = exploreHomeViewModel,
            )
        }
        composable<Category> { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry<Explore>()
            }
            val viewModel: ExploreScreenViewModel = hiltViewModel(parentEntry)
            val categoryArg = backStackEntry.toRoute<Category>().name

            CategoryScreen(
                viewModel = viewModel,
                onBack = {
                    navController.navigate(
                        _root_ide_package_.com.example.nectar.ui.navigation.Explore
                    )
                },
                onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                },
                category = categoryArg,
                onFilterClick = {
                    navController.navigate(Filter)
                },
            )
        }


        composable<Filter> { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry<Explore>()
            }
            val viewModel: ExploreScreenViewModel = hiltViewModel(parentEntry)
            FilterScreen(
                viewModel = viewModel, onClose = { navController.popBackStack() })
        }

        composable<Cart> {
            CartScreen(
                modifier = Modifier.padding(contentPadding),
////                onCheckout = {
////                    navController.navigate(Order)
////                }
                onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                }, onGoToOrder = {
                    navController.navigate(Order) {
                        popUpTo(Cart) { inclusive = true }
                    }
                })
        }

        composable<Favourite> {
            FavoriteScreen(
                modifier = Modifier.padding(contentPadding), onProductClick = { productId ->
                    navController.navigate(Product(id = productId))
                })
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
                })
        }
    }
}
