package com.example.nectar.ui.screens.ProductDetail

import android.graphics.Color
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.theme.BottomSheetBackgroundColor
import com.example.nectar.ui.theme.DarkGray
import com.example.nectar.ui.theme.NectarTheme
import com.example.nectar.ui.theme.SearchTextColor
import com.example.nectar.ui.theme.Transparent
import com.example.nectar.ui.theme.White


@Composable
fun ExpandableItem(
    title: String,
    content: String,
    extra: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier,
    isInitiallyExpanded: Boolean = false,
) {
    var isExpanded by remember { mutableStateOf(isInitiallyExpanded) }

    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "Arrow rotation"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        colors = CardDefaults.cardColors(containerColor = Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(durationMillis = 100)
                )
                .padding(bottom = 16.dp , top = 16.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = Black,
                    modifier = Modifier.weight(1f)
                )
                extra?.invoke()
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                    tint = Black,
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(rotationAngle)
                )
            }

            // Expandable Content
            if (isExpanded) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = content,
                    fontSize = 14.sp,
                    color = SearchTextColor,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun ExpandableItemPreview() {
    NectarTheme {


    ExpandableItem(
        title = "Nectar",
        content = "Nectar is a leading online grocery store that offers a wide range of products, including fresh fruits, vegetables, dairy, and more. Enjoy convenient shopping with fast delivery.",
        isInitiallyExpanded = false
    )
    }
}