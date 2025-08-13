package com.example.nectar.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WideButton(
    text: String,
    onClick:  () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick =  onClick ,
        modifier = modifier
            .width(360.dp)
            .height(70.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Text(text, style = MaterialTheme.typography.titleMedium)
    }
}