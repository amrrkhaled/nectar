package com.example.nectar.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.nectar.domain.model.Product

class HomeScreenViewModel : ViewModel() {


    fun fetchProducts(): List<Product> {
        // Simulating a network call or database fetch
        // In a real application, this would be replaced with actual data fetching logic
        return listOf(
            Product(
                id = 1,
                name = "Apple",
                detail = "1kg",
                imageUrl = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
                price = 2.99,
                description = "Fresh and juicy apples.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "52 kcal", "Protein" to "0.3 g"),
                review = 4,
                isFavorite = false
            ),
            Product(
                id = 2,
                name = "Banana",
                detail = "1kg",
                imageUrl = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
                price = 1.99,
                description = "Sweet and ripe bananas.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "89 kcal", "Protein" to "1.1 g"),
                review = 5,
                isFavorite = true
            ), Product(
                id = 1,
                name = "Apple",
                detail = "1kg",
                imageUrl = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
                price = 2.99,
                description = "Fresh and juicy apples.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "52 kcal", "Protein" to "0.3 g"),
                review = 4,
                isFavorite = false
            ),
            Product(
                id = 2,
                name = "Banana",
                detail = "1kg",
                imageUrl = "https://example.com/banana.jpg",
                price = 1.99,
                description = "Sweet and ripe bananas.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "89 kcal", "Protein" to "1.1 g"),
                review = 5,
                isFavorite = true
            ), Product(
                id = 1,
                name = "Apple",
                detail = "1kg",
                imageUrl = "https://example.com/apple.jpg",
                price = 2.99,
                description = "Fresh and juicy apples.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "52 kcal", "Protein" to "0.3 g"),
                review = 4,
                isFavorite = false
            ),
            Product(
                id = 2,
                name = "Banana",
                detail = "1kg",
                imageUrl = "https://example.com/banana.jpg",
                price = 1.99,
                description = "Sweet and ripe bananas.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "89 kcal", "Protein" to "1.1 g"),
                review = 5,
                isFavorite = true
            ), Product(
                id = 1,
                name = "Apple",
                detail = "1kg",
                imageUrl = "https://example.com/apple.jpg",
                price = 2.99,
                description = "Fresh and juicy apples.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "52 kcal", "Protein" to "0.3 g"),
                review = 4,
                isFavorite = false
            ),
            Product(
                id = 2,
                name = "Banana",
                detail = "1kg",
                imageUrl = "https://example.com/banana.jpg",
                price = 1.99,
                description = "Sweet and ripe bananas.",
                category = "Fruits",
                nutrition = mapOf("Calories" to "89 kcal", "Protein" to "1.1 g"),
                review = 5,
                isFavorite = true
            )
        )
    }


}