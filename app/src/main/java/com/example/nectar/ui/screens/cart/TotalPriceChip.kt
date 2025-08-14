package com.example.nectar.ui.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.theme.CheckoutButtonColor
import com.example.nectar.ui.theme.LightGray
import com.example.nectar.ui.theme.White

@Composable
fun TotalPriceChip(
    totalPrice:Double,
    modifier: Modifier = Modifier,

    ) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(CheckoutButtonColor)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$"+totalPrice.toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = White
        )
    }
}