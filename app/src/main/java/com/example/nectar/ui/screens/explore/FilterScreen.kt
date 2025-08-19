package com.example.nectar.ui.screens.explore


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.example.nectar.ui.components.WideButton
import com.example.nectar.ui.theme.BottomSheetBackgroundColor
import com.example.nectar.ui.theme.NectarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(
    viewModel: ExploreScreenViewModel,
    onClose: () -> Unit = {},
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    "Filters",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }, navigationIcon = {
                IconButton(onClick = { onClose() }) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)

                    )
                }
            })
        },

        ) { paddingValues ->
        FilterScreenContent(
            modifier = Modifier.padding( PaddingValues(
                start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                top = paddingValues.calculateTopPadding(),
                end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                bottom = 0.dp
            )), viewModel = viewModel, onClose = onClose
        )

    }
}

@Composable
fun FilterScreenContent(
    modifier: Modifier = Modifier, viewModel: ExploreScreenViewModel, onClose: () -> Unit
) {
    val searchFilter by viewModel.searchFilter.collectAsState()
    var selectedCategories by remember(searchFilter.categories) {
        mutableStateOf(searchFilter.categories?.toSet() ?: emptySet())
    }
    var maxPrice by remember(searchFilter.maxPrice) {
        mutableStateOf(searchFilter.maxPrice?.toFloat() ?: 10f) // default 100
    }
    val isSearching by viewModel.isSearching.collectAsState()
    val categories = listOf(
        "Fresh Fruits & Vegetable",
        "Cooking Oil & Ghee",
        "Meat & Fish",
        "Bakery & Snacks",
        "Dairy & Eggs",
        "Beverages",

        )

    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        shape = RoundedCornerShape(
            topStart = 32.dp, topEnd = 32.dp, bottomStart = 0.dp, bottomEnd = 0.dp
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = BottomSheetBackgroundColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            if(isSearching){

            Text(
                text = "Categories",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            categories.forEach { category ->
                CheckBoxWithCategory(
                    isChecked = selectedCategories.contains(category),
                    onCheckedChange = { isChecked ->
                        selectedCategories = if (isChecked) {
                            selectedCategories + category
                        } else {
                            selectedCategories - category
                        }
                    },
                    label = category
                )

            }
            }
            Spacer(modifier = Modifier.height(32.dp))

            // Max Price Slider
            Text(
                text = "Max Price: \$${String.format("%.2f", maxPrice)}",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 22.sp
            )
            Slider(
                value = maxPrice,
                onValueChange = { maxPrice = it },
                valueRange = 0f..20f, // adjust max price as needed
                steps = 10 // optional: steps in the slider
            )

            // Push the button to bottom
            Spacer(modifier = Modifier.weight(1f))

            // Apply Filter Button
            WideButton(
                text = "Apply Filters",
                onClick = {
                    viewModel.updateSearchFilter(
                        searchFilter.copy(
                            categories = if(isSearching) selectedCategories?.toList() else null,
                            maxPrice = maxPrice.toDouble()
                        )
                    )
                    viewModel.searchProducts()
                    onClose()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
            )
        }
    }
}

@Preview
@Composable
fun FilterScreenPreview() {
    NectarTheme {
//        FilterScreen(onClose = {}, onApplyFilter = { selectedCategories, selectedBrands ->
//            // Handle the applied filters
//        })
    }
}