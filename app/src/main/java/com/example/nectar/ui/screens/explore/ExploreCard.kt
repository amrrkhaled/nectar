package com.example.nectar.ui.screens.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.domain.model.Category
import com.example.nectar.ui.theme.NectarTheme

@Composable
fun ExploreCard(
    category: Category,
    onCardClick:  () -> Unit
) {
    val boxColor = colorResource(id = category.colorRes)
    val borderColor = colorResource(id = category.borderRes)
    Box(
        modifier = Modifier
            .clickable { onCardClick() }
            .width(175.dp)
            .height(190.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(boxColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = stringResource(id = category.nameRes),
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(id = category.nameRes),
                style =  MaterialTheme.typography.titleMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ExploreCardPreview() {
    NectarTheme {
        ExploreCard(
            Category(
                nameRes = R.string.category1,
                imageRes = R.drawable.category1,
                colorRes = R.color.fruits_card_color,
                borderRes = R.color.fruits_border_color
            ),
            onCardClick = {}
        )
    }

}
