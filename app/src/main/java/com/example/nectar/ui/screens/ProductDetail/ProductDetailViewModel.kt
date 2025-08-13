package com.example.nectar.ui.screens.ProductDetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.usecase.cartItems.AddToCartUseCase
import com.example.nectar.domain.usecase.products.GetBestSellingUseCase
import com.example.nectar.domain.usecase.products.GetExclusiveOfferUseCase
import com.example.nectar.domain.usecase.products.GetProductByIdUseCase
import com.example.nectar.domain.usecase.products.GetProductsUseCase
import com.example.nectar.domain.usecase.products.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    savedStateHandle: SavedStateHandle


) : ViewModel() {

    val productIdd: Int = checkNotNull(savedStateHandle["id"])

    private val _productId = MutableStateFlow<Int>(productIdd)
    val productId = _productId.asStateFlow()


    private val _product = MutableStateFlow<Product>(Product(
        id = 0,
        name = "",
        description = "",
        price = 0.0,
        imageUrl = "",
        category = "",
        detail = "",
        isFavorite = false,
        nutrition = mapOf(),
        review = 5,
    ))
    val product = _product.asStateFlow()

    init {
        viewModelScope.launch {
            val productResult = getProductByIdUseCase(_productId.value)
            _product.value = productResult
        }
    }


    fun toggleFavorite() {
        _product.value = _product.value.copy(isFavorite = !_product.value.isFavorite)
        viewModelScope.launch {
            toggleFavoriteUseCase(productId.value)

        }
    }

    fun addToBasket(productId: Int , quantity: Int = 1) {
        Log.e("ProductViewModel", "Adding product with ID:  to cart")

        val cartItem = CartItem(
            id = 0,
            productId = productId,
            quantity = quantity,
        )
        viewModelScope.launch {
            addToCartUseCase(cartItem)
        }
    }
}