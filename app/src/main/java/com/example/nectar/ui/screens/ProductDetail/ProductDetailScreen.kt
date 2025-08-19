package com.example.nectar.ui.screens.ProductDetail


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.Divider
import com.example.nectar.ui.components.WideButton
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.SearchTextColor

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
            modifier = Modifier.padding(innerpading), product = product, viewModel = viewModel
        )
    }
}


@Composable
fun ProductDetail(
    modifier: Modifier = Modifier, product: Product, viewModel: ProductDetailViewModel
) {
    var quantity by remember { mutableStateOf(1) }
    val totalPrice = product.price * quantity
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Image & Top Bar
        ImageCard(product)

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            TitleAndFavorite(
                product = product,
                isFavorite = product.isFavorite,
                onFavoriteClick = { viewModel.toggleFavorite() })

            Spacer(modifier = Modifier.height(8.dp))

            // Short Detail
            Text(
                product.detail,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = SearchTextColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Quantity & Price
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
                text = "Add to Basket", onClick = {
                    viewModel.addToBasket(product.id, quantity)
                    quantity = 1
                    Toast.makeText(context, "Added $quantity item(s) to basket", Toast.LENGTH_SHORT)
                        .show()
                }, modifier = Modifier.align(Alignment.CenterHorizontally)

            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailScreenPreview() {
    NectarTheme {

    }
}
