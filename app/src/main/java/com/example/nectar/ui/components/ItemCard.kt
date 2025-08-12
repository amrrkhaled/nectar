package com.example.nectar.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.nectar.R
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.theme.CustomShapes
import com.example.nectar.ui.theme.LightGray
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun ProductCard(onAddToCart: () -> Unit = {}, product: Product, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(170.dp)
            .height(250.dp),
        shape = CustomShapes.card,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(color = LightGray, width = 1.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                     .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = product.name,
                    contentScale = ContentScale.Fit, // Changed to Fit for better proportions
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1
                )

                Text(
                    text = product.detail, // "7pcs, Priceg" or similar
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )

                AddToCartButton(onAddToCart =  onAddToCart )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCardPreview() {
    NectarTheme {


        ProductCard(
            product = Product(
                id = 0,
                name = "Natural Red Apple",
                detail = "1kg",
                imageUrl = "https://img.freepik.com/premium-photo/red-apple-with-white-background-shadow-it_14117-4740.jpg",
                price = 4.99,
                description = "Apples are nutritious. Apples may be good for weight loss. Apples may be good for your heart. As part of a healthful and varied diet.",
                category = "Fresh Fruits & Vegetable",
                nutrition = mapOf(
                    "Energy" to "52 kcal",
                    "Protein" to "0.3 g",
                    "Carbohydrates" to "14 g",
                    "Fat" to "0.2 g",
                    "Fiber" to "2.4 g"
                ),
                review = 5,
                isFavorite = false,
            ),
            modifier = Modifier,
            onAddToCart = {}
        )
    }
}