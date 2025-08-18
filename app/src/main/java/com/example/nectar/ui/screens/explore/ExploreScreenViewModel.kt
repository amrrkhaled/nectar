package com.example.nectar.ui.screens.explore

import android.util.Log
import android.util.Log.v
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.R
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Category
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.model.SearchFilter
import com.example.nectar.domain.usecase.cartItems.AddToCartUseCase
import com.example.nectar.domain.usecase.cartItems.DecrementItemUseCase
import com.example.nectar.domain.usecase.cartItems.GetCartItemsUseCase
import com.example.nectar.domain.usecase.cartItems.GetTotalPriceUseCase
import com.example.nectar.domain.usecase.cartItems.GoToCheckoutUseCase
import com.example.nectar.domain.usecase.cartItems.IncrementItemUseCase
import com.example.nectar.domain.usecase.cartItems.RemoveItemUseCase
import com.example.nectar.domain.usecase.explore.GetProductsByCategoryUseCase
import com.example.nectar.domain.usecase.explore.SearchProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreScreenViewModel @Inject constructor(
    private val searchProductsUseCase: SearchProductsUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    private val getProductsByCategoryUseCase: GetProductsByCategoryUseCase
) : ViewModel() {

    val categories = listOf(
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

    private val _searchResults = MutableStateFlow<List<Product>>(emptyList())
    val searchResults = _searchResults.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _searchFilter = MutableStateFlow<SearchFilter>(
        SearchFilter(
            queryText = "",
        )
    )
    val searchFilter = _searchFilter.asStateFlow()

    fun updateSearchFilter(newFilter: SearchFilter) {
        _searchFilter.value = newFilter
        Log.d("ExploreScreenViewModel", "Search filter updated: $newFilter")
    }
    fun resetSearchFilter() {
        _searchFilter.value = SearchFilter(queryText = "")
        Log.d("ExploreScreenViewModel", "Search filter reset")
    }
    fun searchProducts() {

        viewModelScope.launch {
            val results = searchProductsUseCase(searchFilter.value)
            _searchResults.value = results
            _isSearching.value = true


        }
    }

    fun cancelSearch() {
        _isSearching.value = false
        _searchResults.value = emptyList()
    }

    fun addToCart(productId: Int) {
        Log.e("HomeViewModel", "Adding product with ID:  to cart")

        val cartItem = CartItem(
            id = 0,
            productId = productId,
            quantity = 1,
        )
        viewModelScope.launch {
            addToCartUseCase(cartItem)
        }
    }

    private val _categoryProducts = MutableStateFlow<List<Product>>(emptyList())
    val categoryProducts = _categoryProducts.asStateFlow()

    fun getProductsByCategory(category: String) {
        Log.d("ExploreScreenViewModel", "Fetching products for category: $category")
        viewModelScope.launch {
            val results = getProductsByCategoryUseCase(category)
            _categoryProducts.value = results
        }
    }


    private val _focusSearchBarEvent = MutableStateFlow(false)
    val focusSearchBarEvent: StateFlow<Boolean> = _focusSearchBarEvent

    fun triggerSearchFocus() {
        _focusSearchBarEvent.value = true
    }

    fun consumeSearchFocus() {
        _focusSearchBarEvent.value = false
    }
}