package com.example.nectar.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductCard
import com.example.nectar.ui.theme.Black

@Composable
fun ProductsRow(
    title : String = "Products",
    products: List<Product>,
    onAddToCart: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column{
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Products",
            modifier = Modifier.padding(0.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Black
        )
        Text(
            text = "See All",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(16.dp)
                .clickable { /* Navigate to all products */ }
        )

    }
    
    LazyRow(
        contentPadding = PaddingValues(start = 0.dp, end = 16.dp), // no space at start
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(products.size) { index ->
            ProductCard(product = products[index], onAddToCart = { /* ... */ })
        }
    }

}}