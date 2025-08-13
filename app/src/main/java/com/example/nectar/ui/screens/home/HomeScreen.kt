package com.example.nectar.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductGrid
import com.example.nectar.ui.components.SearchBar
import com.example.nectar.ui.theme.NectarTheme
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onProductClick: (Int) -> Unit,
) {


    val bestSelling by viewModel.bestSellingProducts.collectAsState()
    val exclusiveOffer by viewModel.exclusiveProducts.collectAsState()

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    )
    {
        val horizontalPadding = 16.dp

        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                SearchBar(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
            ) {
                Banner(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
            ) {
                ProductsRow(
                    title = "Exclusive Offer", products = exclusiveOffer,
                    onAddToCart = { id ->
                        viewModel.addToCart(id) },
                    onProductClick = onProductClick,
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        item {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
            ) {
                ProductsRow(title = "Best Selling", products = bestSelling, onProductClick = onProductClick )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }
}

@Composable
fun ImageBanner(images: List<String>, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    // Automatically change image every 3 seconds
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentIndex = (currentIndex + 1) % images.size
        }
    }

    AsyncImage(
        model = images[currentIndex],
        contentDescription = "Banner",
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    NectarTheme {
//        HomeScreen()
    }
}


