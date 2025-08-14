package com.example.nectar.ui.screens.cart


import android.R.attr.category
import android.R.attr.description
import android.R.attr.name
import android.R.attr.onClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.CartItemView
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.Divider
import com.example.nectar.ui.components.ProductCard
import com.example.nectar.ui.components.ProductGrid
import com.example.nectar.ui.components.WideButton
import com.example.nectar.ui.screens.favorite.CartScreenViewModel
import com.example.nectar.ui.screens.favorite.FavoriteScreenViewModel
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    onProductClick: (Int) -> Unit = {},
    onGoToOrder: () -> Unit
) {


    val viewModel: CartScreenViewModel = hiltViewModel()
    val cartItems by viewModel.cartItems.collectAsState()
    val cartPrice by viewModel.cartPrice.collectAsState()

    Divider(modifier)
    Box(
        modifier = Modifier.fillMaxSize(),

    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
            .padding(bottom = 128.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(cartItems.size) { index ->
                CartItem(
                    cartItem = cartItems[index],
                    onIncrement = { viewModel.incrementItem(cartItems[index].productId) },
                    onDecrement = { viewModel.decrementItem(cartItems[index].productId) },
                    onRemove = { viewModel.removeItem(cartItems[index].productId) },
                    modifier = Modifier.clickable {
                        onProductClick(cartItems[index].productId)
                    })
                Divider(modifier = Modifier.width(365.dp))
            }
        }

        WideButton(
            text = "Go to Checkout",
            modifier = Modifier.padding(bottom = 128.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                if (cartItems.isEmpty()) return@WideButton
                viewModel.goToCheckout()
                onGoToOrder()
            },
            extra = {
                TotalPriceChip(
                    totalPrice = cartPrice, modifier = Modifier.padding(start = 8.dp)
                )
            })
    }
}


@Preview(showBackground = true)
@Composable
fun ProductGridPreview() {
    NectarTheme {
        CartScreen(
            onProductClick = {},
            onGoToOrder = {}
        )
    }
}