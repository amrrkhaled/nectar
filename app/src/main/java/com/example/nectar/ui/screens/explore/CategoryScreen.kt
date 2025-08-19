package com.example.nectar.ui.screens.explore


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Tune
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.ProductGrid
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.util.normalizeCategory

@Composable
fun CategoryScreen(
    viewModel: ExploreScreenViewModel,
    category: String,
    onBack: () -> Unit = {},
    onProductClick: (Int) -> Unit,
    onFilterClick: () -> Unit = {}
) {
    // Normalize category (to remove spaces and special characters)
    val normalizedCategory = remember(category) { normalizeCategory(category) }

    // Fetch products when category changes
    LaunchedEffect(normalizedCategory) {
        viewModel.getProductsByCategory(normalizedCategory)
    }

    val products by viewModel.categoryProducts.collectAsState()

    Scaffold(
        topBar = {
            CategoryTopAppBar(
                category = normalizedCategory, onBack = onBack, onFilterClick = onFilterClick
            )
        }) { padding ->
        CategoryContent(
            products = products,
            onProductClick = onProductClick,
            onAddToCart = { productId -> viewModel.addToCart(productId) },
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryTopAppBar(
    category: String, onBack: () -> Unit = {}, onFilterClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = {
        Text(text = category)
    }, navigationIcon = {
        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Back", tint = Black)
        }
    }, actions = {
        IconButton(onClick = onFilterClick) {
            Icon(Icons.Filled.Tune, contentDescription = "Filter", tint = Black)
        }
    })
}

@Composable
fun CategoryContent(
    products: List<Product>,
    onProductClick: (Int) -> Unit,
    onAddToCart: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    ProductGrid(
        products = products,
        onProductClick = onProductClick,
        onAddToCart = onAddToCart,
        modifier = modifier.padding(start = 25.dp, end = 25.dp, bottom = 16.dp)
    )
}
