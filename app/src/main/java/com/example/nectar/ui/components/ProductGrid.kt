package com.example.nectar.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun ProductGrid(
    products: List<Product>,
    onAddToCart: (Int) -> Unit,
    modifier: Modifier = Modifier,
    onProductClick: (Int) -> Unit,
    userScrollEnabled: Boolean = true,
    ignoreBottomPadding: Boolean = false,

    ) {
    LazyVerticalGrid(
        userScrollEnabled = userScrollEnabled,
        modifier = modifier.padding(
            start = 0.dp, end = 0.dp, top = 0.dp, bottom = if (ignoreBottomPadding) 0.dp else 88.dp

        ),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductCard(
                product = products[index],
                onAddToCart = { onAddToCart(products[index].id) },
                onProductClick = { onProductClick(products[index].id) })
        }
    }

}

@Preview
@Composable
fun ProductGridPreview() {
    NectarTheme {}
}