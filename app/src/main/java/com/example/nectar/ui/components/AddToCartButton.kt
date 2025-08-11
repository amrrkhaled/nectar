package com.example.nectar.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.theme.CustomShapes
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun AddToCartButton(
    onAddToCart: () -> Unit, modifier: Modifier = Modifier
) {
    Button(
        onClick = onAddToCart,
        modifier = modifier.size(48.dp),
        shape = CustomShapes.large,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary // directly green
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add to Cart",
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddToCartButtonPreview() {
    NectarTheme {
        AddToCartButton(onAddToCart = {})
    }

}
