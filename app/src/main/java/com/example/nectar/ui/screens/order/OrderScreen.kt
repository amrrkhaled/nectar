package com.example.nectar.ui.screens.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.R
import com.example.nectar.ui.components.WideButton
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.theme.DarkGray
import com.example.nectar.ui.theme.GradientBottom
import com.example.nectar.ui.theme.GradientMiddle
import com.example.nectar.ui.theme.GradientTop
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.SearchTextColor

@Composable
fun OrderScreen(
    onBackToHome: () -> Unit = {},
) {

    val gradientColors = listOf(
        GradientTop,
        GradientMiddle,
        GradientBottom
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = gradientColors
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Success icon image
            Image(
                painter = painterResource(id = R.drawable.order),
                contentDescription = "Order Image",
                modifier = Modifier.padding(top = 150.dp).width(270.dp).height(240.dp)
            )

            // Title text
            Text(
                text = "Your Order has been accepted",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 65.dp, start = 75.dp, end = 75.dp),
                textAlign = TextAlign.Center,

                )

            // Subtitle text
            Text(
                text = "Your items has been placcd and is on \n" +
                        "it’s way to being processed",
                style = MaterialTheme.typography.bodyMedium,
                color = SearchTextColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp, bottom = 32.dp)
            )

            // "Track Order" button
            WideButton(
                text = "Track Order",
                modifier = Modifier.padding(top = 80.dp),

                onClick = { /* Navigate to tracking */ }
            )

            // "Back to home" button
            WideButton(
                text = "Back to home",
                onClick = onBackToHome,
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Black // Text color
                )
            )
        }
    }

}
@Preview
@Composable
fun OrderScreenPreview() {
    NectarTheme {
        OrderScreen()

    }
}