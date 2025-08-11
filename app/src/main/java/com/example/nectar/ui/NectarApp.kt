package com.example.nectar.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductCard
import com.example.nectar.ui.navigation.AppNavHost
import kotlinx.serialization.Serializable

@Composable
fun NectarApp() {

    val navController = rememberNavController()
    AppNavHost(navController = navController)

    ProductCard(
        product =  Product(
            id = 0,
            name = "Natural Red Apple",
            detail = "1kg",
            imageUrl = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
            price = 4.99,
            description = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart. As part of a healthful and varied diet.",
            category = "Fresh Fruits & Vegetable",
            nutrition = mapOf(
                "Energy" to "52 kcal",
                "Protein" to "0.3 g",
                "Carbohydrates" to "14 g",
                "Fat" to "0.2 g",
                "Fiber" to "2.4 g"
            ),
            review = 5,
            isFavorite = false,
        ),
        modifier = Modifier
    )

}

