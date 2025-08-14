package com.example.nectar.ui.screens.ProductDetail


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.Divider
import com.example.nectar.ui.components.WideButton
import com.example.nectar.ui.theme.*

@Composable
fun ProductDetailScreen(onBack: () -> Unit, viewModel: ProductDetailViewModel) {
    val product = viewModel.product.collectAsState().value
    val context = LocalContext.current
    Scaffold(
        topBar = {
            ProductDetailTopBar(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Transparent),
                onBack = onBack,
                onShare = {
                    shareProduct(context = context, product = product)
                })
        }) { innerpading ->

        ProductDetail(
            modifier = Modifier.padding(innerpading),
            product = product,
            viewModel = viewModel
            )
    }
}


@Composable
fun ProductDetail(
    modifier: Modifier = Modifier,
    product: Product,
    viewModel: ProductDetailViewModel
) {
//    val viewModel: ProductDetailViewModel = hiltViewModel()
//    val product = viewModel.product.collectAsState().value
    var quantity by remember { mutableStateOf(1) }
    val totalPrice = product.price * quantity
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // --- Image & Top Bar ---
        ImageCard(product)

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            // --- Title & Favorite ---
            TitleAndFavorite(
                product = product,
                isFavorite = product.isFavorite,
                onFavoriteClick =  {viewModel.toggleFavorite() }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // --- Short Detail ---
            Text(
                product.detail,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = SearchTextColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            // --- Quantity & Price ---
            QuantityAndPrice(
                quantity = quantity,
                totalPrice = totalPrice,
                onQuantityChange = { newQuantity ->
                    quantity = newQuantity
                },
            )

            Spacer(modifier = Modifier.height(12.dp))

            Divider()
            ExtraInfo(product)


            Spacer(modifier = Modifier.height(16.dp))

            WideButton(
                text = "Add to Basket",
                onClick = { viewModel.addToBasket(product.id,quantity)
                          quantity =1
                    Toast.makeText(context, "Added $quantity item(s) to basket", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailScreenPreview() {
    NectarTheme {
//        val sampleProduct = Product(
//            id = 1,
//            name = "Sample Product",
//            detail = "This is a sample product detail.",
//            description = "This product is great for testing purposes.",
//            price = 19.99,
//            imageUrl = "https://via.placeholder.com/150",
//            category = "Fruits",
//            isFavorite = true,
//            nutrition = mapOf("Calories" to "200", "Protein" to "5g"),
//            review = 2
//        )
//
//        ProductDetailScreen(
//            product = sampleProduct,
//            onBack = {},
//            onAddToBasket = {}
//        )
//        ProductDetailScreen(onBack = {},)
    }
}
