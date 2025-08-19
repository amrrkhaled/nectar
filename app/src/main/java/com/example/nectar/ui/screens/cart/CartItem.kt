package com.example.nectar.ui.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.nectar.R
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.CartItemView
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.components.Divider
import com.example.nectar.ui.components.IncrementDecrement
import com.example.nectar.ui.components.WideButton
import com.example.nectar.ui.screens.ProductDetail.QuantityAndPrice
import com.example.nectar.ui.theme.DarkGray
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.SearchTextColor

@Composable
fun CartItem(
    cartItem: CartItemView,
    onRemove: () -> Unit = {},
    onIncrement : (Int) -> Unit = {},
    onDecrement : (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .width(
                365.dp
            )
            .padding(16.dp)
    ) {
        // Product Image
        Image(
            painter = rememberAsyncImagePainter(cartItem.imageUrl),
            contentDescription = cartItem.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Product Details
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = cartItem.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(
                    onClick = onRemove,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Remove from cart",
                        tint = SearchTextColor,
                    )
                }
            }

            Text(
                text = cartItem.detail,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = SearchTextColor
            )

            Spacer(modifier = Modifier.height(4.dp))

            QuantityAndPriceCart(
                quantity = cartItem.quantity,
                totalPrice = cartItem.price * cartItem.quantity,
                 onIncrement = { onIncrement(cartItem.productId) },
                 onDecrement = { onDecrement(cartItem.productId) }

            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartTopBar(
    title: String = "My Cart"
) {
    CenterAlignedTopAppBar(
        title = { Text(title, fontWeight = FontWeight.Bold) },
    )


}



@Preview(showBackground = true)
@Composable
fun CartItemview() {
    NectarTheme {
        CartItem(
            cartItem = CartItemView(
                id = 0,
                name = "Sample Product",
                price = 10.0,
                imageUrl = "https://example.com/sample.jpg",
                detail = "TODO()",
                productId = 2,
                quantity = 3

                ),
        )
    }
}