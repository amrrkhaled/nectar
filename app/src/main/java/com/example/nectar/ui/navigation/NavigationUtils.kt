package com.example.nectar.ui.navigation


import androidx.navigation.NavController
import androidx.navigation.NavOptions

fun NavController.navigateToBottomNavDestination(route: Any) {
    navigate(route) {
        popUpTo(graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavController.navigateAndClearStack(route: Any) {
    navigate(route) {
        popUpTo(graph.startDestinationId) {
            inclusive = true
        }
    }
}