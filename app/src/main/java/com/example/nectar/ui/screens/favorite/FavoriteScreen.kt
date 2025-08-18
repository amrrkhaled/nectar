package com.example.nectar.ui.screens.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductGrid

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    onProductClick: (Int) -> Unit,
) {
    val viewModel: FavoriteScreenViewModel = hiltViewModel()
    val favoriteProducts by viewModel.favoriteProducts.collectAsState()
    ProductGrid(
        modifier = modifier.padding(start = 25.dp, end = 25.dp),
        products = favoriteProducts,
        onProductClick = onProductClick,
        onAddToCart = { id -> viewModel.addToCart(id)
        })


}

@Preview
@Composable
fun FavoriteScreenPreview() {

//    FavoriteScreen()

}

