package com.example.nectar.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun ProductGrid(
    products: List<Product>,
    onAddToCart: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columns side by side
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductCard(product = products[index], onAddToCart = { /* ... */ } , onProductClick = {})
        }
    }

}

@Preview
@Composable
fun ProductGridPreview() {
    NectarTheme {
    ProductGrid(
        products = listOf(
            Product(
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
    )
}
}