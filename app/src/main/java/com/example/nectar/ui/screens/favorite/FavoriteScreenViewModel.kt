package com.example.nectar.ui.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.usecase.cartItems.AddToCartUseCase
import com.example.nectar.domain.usecase.products.GetBestSellingUseCase
import com.example.nectar.domain.usecase.products.GetExclusiveOfferUseCase
import com.example.nectar.domain.usecase.products.GetFavoritesUseCase
import com.example.nectar.domain.usecase.products.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteScreenViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val addToCartUseCase: AddToCartUseCase,

) : ViewModel() {

    private val _favoriteProducts = MutableStateFlow<List<Product>>(emptyList())
    val favoriteProducts = _favoriteProducts.asStateFlow()


    init {

        viewModelScope.launch {
            getFavoritesUseCase().collect { products ->
                _favoriteProducts.value = products
            }
        }
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

}