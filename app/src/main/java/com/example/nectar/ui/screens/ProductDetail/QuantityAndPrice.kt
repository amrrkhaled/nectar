package com.example.nectar.ui.screens.ProductDetail

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.components.IncrementDecrement
import com.example.nectar.ui.theme.Black

@Composable
fun QuantityAndPrice(
    quantity: Int,
    totalPrice: Double,
    onQuantityChange: (Int) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IncrementDecrement(
            value = quantity,
            onIncrement = { onQuantityChange(quantity + 1) },
            onDecrement = { if (quantity > 1) onQuantityChange(quantity - 1) }
        )
        Text(
            text = "$${"%.2f".format(totalPrice)}",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold, fontSize = 24.sp
            ),
            color = Black
        )
    }
}