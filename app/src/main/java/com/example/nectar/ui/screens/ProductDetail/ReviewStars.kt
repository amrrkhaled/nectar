package com.example.nectar.ui.screens.ProductDetail

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.nectar.ui.theme.StarColor

@Composable
fun ReviewStars(
    rating: Int,
) {
    Row {
        repeat(rating) {
            Icon(
                Icons.Default.Star,
                contentDescription = null,
                tint = StarColor
            )
        }
    }
}