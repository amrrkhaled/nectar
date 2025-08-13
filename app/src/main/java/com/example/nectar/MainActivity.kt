package com.example.nectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import com.example.nectar.domain.model.Product
import com.example.nectar.ui.NectarApp
import com.example.nectar.ui.screens.ProductDetail.ProductDetailScreen
import com.example.nectar.ui.theme.NectarTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NectarTheme {
//                val sampleProduct = Product(
//                    id = 1,
//                    name = "Sample Product",
//                    detail = "This is a sample product detail.",
//                    description = "This product is great for testing purposes.",
//                    price = 19.99,
//                    imageUrl = "https://via.placeholder.com/150",
//                    category = "Fruits",
//                    isFavorite = true,
//                    nutrition = mapOf("Calories" to "200", "Protein" to "5g"),
//                    review = 2
//                )
//
//                ProductDetailScreen(
//                    product = sampleProduct,
//                    onBack = {},
//                    onAddToBasket = {}
//                )
                NectarApp()
//                ProductDetailScreen(onBack = {})
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hellopo $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NectarTheme {
        Greeting("Android")
    }
}