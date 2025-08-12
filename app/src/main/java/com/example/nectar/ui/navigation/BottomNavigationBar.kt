package com.example.nectar.ui.navigation


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.theme.Transparent
import com.example.nectar.ui.theme.White

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Only show bottom nav on main screens
    val bottomNavRoutes = setOf(
        Shop::class.qualifiedName,
        Explore::class.qualifiedName,
        Cart::class.qualifiedName,
        Favourite::class.qualifiedName,
        Account::class.qualifiedName
    )

    // Hide bottom nav for screens like Product, Order, etc.
    if (currentRoute !in bottomNavRoutes) return

    val bottomNavItems = listOf(
        BottomNavItem("Shop", R.drawable.ic_shop, Shop),
        BottomNavItem("Explore", R.drawable.ic_explore, Explore),
        BottomNavItem("Cart", R.drawable.ic_cart, Cart),
        BottomNavItem("Favourite", R.drawable.ic_fav, Favourite),
        BottomNavItem("Account", R.drawable.ic_account, Account)
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        color = White,
        tonalElevation = 0.dp,
        shadowElevation = 16.dp
    ) {
        NavigationBar(
            containerColor = Transparent,
            tonalElevation = 0.dp
        ) {
            bottomNavItems.forEach { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = item.iconRes),
                            contentDescription = item.label,
                            tint = if (currentRoute == item.route::class.qualifiedName) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                Black
                            }
                        )
                    },
                    selected = currentRoute == item.route::class.qualifiedName,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = Black,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

// Updated data class
data class BottomNavItem(
    val label: String,
    val iconRes: Int,
    val route: Any // Changed to Any to work with serializable objects
)

@Preview
@Composable
fun NavBarPreview() {
    BottomNavigationBar(
        navController = rememberNavController()
    )
}