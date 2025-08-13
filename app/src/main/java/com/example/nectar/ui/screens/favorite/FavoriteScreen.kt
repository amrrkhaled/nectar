package com.example.nectar.ui.screens.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        modifier = modifier,
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

