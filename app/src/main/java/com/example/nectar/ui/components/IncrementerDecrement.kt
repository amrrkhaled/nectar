package com.example.nectar.ui.components

import android.R.attr.contentDescription
import android.service.autofill.Validators.and
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.theme.LightGray
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.ProductDetailColor
import com.example.nectar.ui.theme.RemoveIconColor

@Composable
fun IncrementDecrement(
    value: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = onDecrement,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                Icons.Default.Remove,
                tint = RemoveIconColor,
                contentDescription = "Decrease quantity",
                modifier = Modifier.size(32.dp)
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp)
                .border(
                    width = 1.dp,
                    color = LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Text(
                value.toString(),
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
        }

        IconButton(
            onClick = onIncrement,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                Icons.Default.Add,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = "Increase quantity",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IncrementDecrementPreview() {
    NectarTheme {
        IncrementDecrement(
            value = 1, onIncrement = {}, onDecrement = {}, modifier = Modifier
        )
    }
}