package com.example.nectar.ui.screens.explore

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nectar.ui.components.ProductGrid

@Composable
fun ExploreScreen(
    onProductClick: (Int) -> Unit,
    onFilterClick: () -> Unit = {},
    onCategoryClick: (String) -> Unit = {},
    sharedViewModel: ExploreHomeSharedViewModel,
) {

    val searchFocusTrigger by sharedViewModel.searchBarFocus.collectAsState()
    Log.d("ExploreHomeSharedViewModel", "Search Focus Trigger: $searchFocusTrigger")
    LaunchedEffect(searchFocusTrigger) {
        if (searchFocusTrigger) {
            sharedViewModel.consumeSearchFocus()
        }
    }
    val viewModel: ExploreScreenViewModel = hiltViewModel()
    val isSearching by viewModel.isSearching.collectAsState()

    Scaffold(
        topBar = {
            if (!isSearching) ExploreTopBar()
        },
    ) { paddingValues ->
        ExploreView(
            modifier = Modifier.padding(paddingValues),
            onProductClick = onProductClick,
            viewModel = viewModel,
            onFilterClick = onFilterClick,
            onCategoryClick = onCategoryClick,
            searchFocusTrigger = searchFocusTrigger
        )
    }
}

@Composable
fun ExploreView(
    onFilterClick: () -> Unit,
    modifier: Modifier,
    onProductClick: (Int) -> Unit,
    viewModel: ExploreScreenViewModel,
    onCategoryClick: (String) -> Unit = {},
    searchFocusTrigger: Boolean,
) {
    val isSearching by viewModel.isSearching.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    val searchFilter by viewModel.searchFilter.collectAsState()

    Column(
        modifier = modifier.padding(start = 25.dp, end = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row {
            ExploreSearchBar(
                searchFilter, onSearch = {
                    viewModel.updateSearchFilter(
                        searchFilter.copy(
                            queryText = it.queryText.trim()
                        )
                    )
                    if (it.queryText.isNotBlank()) {
                        viewModel.searchProducts()
                    } else {
                        viewModel.cancelSearch()
                    }
                }, cancelSearch = {
                    viewModel.resetSearchFilter()
                    viewModel.cancelSearch()
                }, modifier = Modifier.weight(1f),
                autoFocus = searchFocusTrigger

            )
            if (isSearching) {
                FilterIcon(
                    onClick = onFilterClick
                )

            }
        }

        if (isSearching) {
            ProductGrid(
                products = searchResults,
                modifier = Modifier.padding(top = 30.dp),
                onProductClick = { id -> onProductClick(id) },
                onAddToCart = { id -> viewModel.addToCart(id) },
            )
        } else {
            ExploreGrid(
                categories = viewModel.categories,
                onCategoryClick = { name -> onCategoryClick(name) })
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreTopBar(
    title: String = "Find Products",
) {
    CenterAlignedTopAppBar(
        title = { Text(title, fontWeight = FontWeight.Bold) },
    )


}

@Preview
@Composable
fun ExploreScreenPreview() {
//    ExploreScreen(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    )
}