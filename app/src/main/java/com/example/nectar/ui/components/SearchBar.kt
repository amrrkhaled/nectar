package com.example.nectar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.ui.theme.Black
import com.example.nectar.ui.theme.DarkGray
import com.example.nectar.ui.theme.LightGray
import com.example.nectar.ui.theme.SearchBackgroundColor
import com.example.nectar.ui.theme.SearchTextColor

@Composable
fun SearchBar(
    placeholder: String = "Search Store",
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(52.dp)
            .width(365.dp)
            .background(
                color = SearchBackgroundColor,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart,

    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search Icon
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Black,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Placeholder text
            Text(
                text = placeholder,
                color = SearchTextColor

            )
        }
    }
}