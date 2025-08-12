package com.example.nectar.ui.components

import android.R.attr.rotation
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.theme.CustomShapes
import com.example.nectar.ui.theme.NectarTheme
import kotlinx.coroutines.delay

@Composable
fun AddToCartButton(
    onAddToCart: () -> Unit, modifier: Modifier = Modifier
) {
    var clicked by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (clicked) 1.5f else 1f)

    Button(
        onClick = {
            if (!clicked) {    // prevent multiple clicks during animation
                clicked = true
                onAddToCart()
            }
        },

        modifier = modifier.size(48.dp),
        shape = CustomShapes.large,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary // directly green
        )
    ) {
        Icon(
            imageVector = if (clicked) Icons.Filled.Check else Icons.Filled.Add,
            contentDescription = "Add to Cart",
            tint = Color.White,
            modifier = Modifier.size(24.dp).scale(scale)
        )
    }
    if (clicked) {
        LaunchedEffect(Unit) {
            delay(1500) // 1.5 second
            clicked = false
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddToCartButtonPreview() {
    NectarTheme {
        AddToCartButton(onAddToCart = {})
    }

}
