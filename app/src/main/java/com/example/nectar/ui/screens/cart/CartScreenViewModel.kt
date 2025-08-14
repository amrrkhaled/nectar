package com.example.nectar.ui.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.CartItemView
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.usecase.cartItems.AddToCartUseCase
import com.example.nectar.domain.usecase.cartItems.DecrementItemUseCase
import com.example.nectar.domain.usecase.cartItems.GetCartItemsUseCase
import com.example.nectar.domain.usecase.cartItems.GetTotalPriceUseCase
import com.example.nectar.domain.usecase.cartItems.GoToCheckoutUseCase
import com.example.nectar.domain.usecase.cartItems.IncrementItemUseCase
import com.example.nectar.domain.usecase.cartItems.RemoveItemUseCase
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
class CartScreenViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val incrementItemUseCase: IncrementItemUseCase,
    private val decrementItemUseCase: DecrementItemUseCase,
   private val removeItemUseCase: RemoveItemUseCase,
    private val totalPriceUseCase: GetTotalPriceUseCase,
private val goToCheckoutUseCase: GoToCheckoutUseCase
) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItemView>>(emptyList())
    val cartItems = _cartItems.asStateFlow()

    private val _cartPrice = MutableStateFlow(2.0)
    val cartPrice = _cartPrice.asStateFlow()


    init {

        viewModelScope.launch {
            getCartItemsUseCase().collect { cartItems ->
                _cartItems.value = cartItems
            }

        }
        viewModelScope.launch {
            totalPriceUseCase().collect { totalPrice ->
                _cartPrice.value = totalPrice
            }
        }
    }

    fun incrementItem(productId: Int) {
        Log.e("CartScreenViewModel", "Incrementing item with product ID: $productId")
        viewModelScope.launch {
            incrementItemUseCase(productId)
        }
    }
    fun decrementItem(productId: Int) {
        Log.e("CartScreenViewModel", "Decrementing item with product ID: $productId")
        viewModelScope.launch {
            decrementItemUseCase(productId)
        }
    }

    fun removeItem(productId: Int) {
        Log.e("CartScreenViewModel", "Removing item with product ID: $productId")
        viewModelScope.launch {
            removeItemUseCase(productId)
        }
    }

    fun goToCheckout() {
        Log.e("CartScreenViewModel", "Going to checkout")
        viewModelScope.launch {
            goToCheckoutUseCase()
        }
    }

}