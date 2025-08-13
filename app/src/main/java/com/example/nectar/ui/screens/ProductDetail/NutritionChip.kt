package com.example.nectar.ui.screens.ProductDetail

import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.theme.DarkGray
import com.example.nectar.ui.theme.LightGray

@Composable
fun NutritionChip(
    weight:Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    backgroundColor: Color = Color(0xFFF2F3F2),
    textColor: Color = Color.Black,

) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(LightGray)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = weight.toString()+"gr",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Black
        )
    }
}

