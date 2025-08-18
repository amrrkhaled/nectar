package com.example.nectar.ui.screens.explore

import android.R.attr.top
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.R
import com.example.nectar.domain.model.Category

@Composable
fun ExploreGrid(
    categories: List<Category>,
    onCategoryClick: (String) -> Unit
) {

     LazyVerticalGrid(
         columns = GridCells.Fixed(2),
         horizontalArrangement = Arrangement.spacedBy(15.dp), // horizontal spacing between items
         verticalArrangement = Arrangement.spacedBy(15.dp),
         modifier = Modifier.padding(top = 20.dp).fillMaxSize(),
     ) {
         items(categories) { category ->
             val categoryName = stringResource(id = category.nameRes)
             ExploreCard(category = category, onCardClick = { onCategoryClick(categoryName) })
         }
     }
}

@Preview(showBackground = true)
@Composable
fun ExploreGridPreview() {
    val sampleCategories = listOf(
        Category(
            nameRes = R.string.category1,
            imageRes = R.drawable.category1,
            colorRes = R.color.fruits_card_color,
            borderRes = R.color.fruits_border_color
        ),
        Category(
            nameRes = R.string.category2,
            imageRes = R.drawable.category2,
            colorRes = R.color.cooking_oil_card_color,
            borderRes = R.color.cooking_oil_border_color
        ),
        Category(
            nameRes = R.string.category3,
            imageRes = R.drawable.category3,
            colorRes = R.color.meat_card_color,
            borderRes = R.color.meat_border_color
        ),
        Category(
            nameRes = R.string.category4,
            imageRes = R.drawable.category4,
            colorRes = R.color.bakery_card_color,
            borderRes = R.color.bakery_border_color
        ),
        Category(
            nameRes = R.string.category5,
            imageRes = R.drawable.category5,
            colorRes = R.color.dairy_card_color,
            borderRes = R.color.dairy_border_color
        ),
        Category(
            nameRes = R.string.category6,
            imageRes = R.drawable.category6,
            colorRes = R.color.beverages_card_color,
            borderRes = R.color.beverages_border_color
        ),
    )

    ExploreGrid(categories = sampleCategories) { /* Handle category click */ }
}