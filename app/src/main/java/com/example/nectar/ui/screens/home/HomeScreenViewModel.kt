package com.example.nectar.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.util.CoilUtils.result
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.usecase.cartItems.AddToCartUseCase
import com.example.nectar.domain.usecase.products.GetBestSellingUseCase
import com.example.nectar.domain.usecase.products.GetExclusiveOfferUseCase
import com.example.nectar.domain.usecase.products.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    private val getExclusiveOfferUseCase: GetExclusiveOfferUseCase,
    private val getBestSellingUseCase: GetBestSellingUseCase
) : ViewModel() {

    private val _exclusiveProducts = MutableStateFlow<List<Product>>(emptyList())
    val exclusiveProducts = _exclusiveProducts.asStateFlow()

    private val _bestSellingProducts = MutableStateFlow<List<Product>>(emptyList())
    val bestSellingProducts = _bestSellingProducts.asStateFlow()

    private val _ready = MutableStateFlow(false)
    val ready: StateFlow<Boolean> = _ready.asStateFlow()

    init {

        viewModelScope.launch {
            val exclusiveProductsResult = getExclusiveOfferUseCase()
            _exclusiveProducts.value = exclusiveProductsResult
            val bestSellingProductsResult = getBestSellingUseCase()
            _bestSellingProducts.value = bestSellingProductsResult
             _ready.value=true
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
