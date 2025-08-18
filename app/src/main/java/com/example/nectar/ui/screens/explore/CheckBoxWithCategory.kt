package com.example.nectar.ui.screens.explore

import android.R.attr.category
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.DarkGray

@Composable
fun CheckBoxWithCategory(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable {
                onCheckedChange(!isChecked)
            }
    ) {
        // Custom checkbox using a rounded square
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(
                    color = if (isChecked) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Transparent
                    },
                    shape = RoundedCornerShape(4.dp)
                )
                .border(
                    width = 1.5.dp,
                    color = if (isChecked) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        DarkGray
                    },
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isChecked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(12.dp)
                )
            }
        }

        Text(
            text = label,
            modifier = Modifier.padding(start = 12.dp),
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )
    }
}