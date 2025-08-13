package com.example.nectar.ui.screens.ProductDetail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.Divider

@Composable
fun ExtraInfo(product : Product) {
    ExpandableItem(
        title = "Product Detail",
        content = product.description,
        modifier = Modifier.fillMaxWidth()
    )
    Divider()
    ExpandableItem(
        title = "Nutritions",
        content = product.nutrition.entries.joinToString("\n") { "${it.key}: ${it.value}" },
        modifier = Modifier.fillMaxWidth(),
        extra = { NutritionChip(100) })
    Divider()
    ExpandableItem(
        title = "Review",
        content = "This product is amazing! I love it. Highly recommend to everyone.",
        modifier = Modifier.fillMaxWidth(),
        extra = { ReviewStars(product.review) })
}