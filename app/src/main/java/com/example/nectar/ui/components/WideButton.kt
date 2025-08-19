package com.example.nectar.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nectar.ui.theme.White

@Composable
fun WideButton(
    text: String,
    onClick: () -> Unit,
    extra: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = White
    )
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(360.dp)
            .height(70.dp),
        shape = RoundedCornerShape(18.dp),
        colors = colors

    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            // Centered main text
            Text(
                text,
                style = MaterialTheme.typography.titleMedium
            )

            // Extra composable
            if (extra != null) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp)
                ) {
                    extra()
                }
            }
        }
    }
}
