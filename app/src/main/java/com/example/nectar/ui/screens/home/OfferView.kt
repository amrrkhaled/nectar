package com.example.nectar.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductCard
import com.example.nectar.ui.components.ProductGrid
import com.example.nectar.ui.theme.Black

@Composable
fun OfferView(
    title: String = "Products",
    products: List<Product>,
    onAddToCart: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
    onProductClick: (Int) -> Unit
) {
    var showGrid by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(0.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Black
            )
            Text(
                text = if (!showGrid) "See All" else "Show Less",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { showGrid = !showGrid }
            )
        }

        if (showGrid) {
            ProductGrid(
                ignoreBottomPadding = true,
                userScrollEnabled = false,
                products = products,
                onProductClick = onProductClick,
                onAddToCart = onAddToCart,
                modifier = Modifier.fillMaxWidth().heightIn(max = 2000.dp)
            )
        } else {
            LazyRow(
                contentPadding = PaddingValues(start = 0.dp, end = 0.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                items(products.size) { index ->
                    ProductCard(
                        product = products[index],
                        onAddToCart = { onAddToCart(products[index].id) },
                        onProductClick = { onProductClick(products[index].id) },
                        modifier = Modifier.width(175.dp)
                    )
                }
            }
        }
    }
}
