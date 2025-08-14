package com.example.nectar.domain.repository

import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.CartItemView
import kotlinx.coroutines.flow.Flow

interface CartItemRepository {

    fun getCartItems(): Flow<List<CartItemView>>

    suspend fun addCartItem(cartItem: CartItem): CartItem

    suspend fun updateCartItem(cartItem: CartItem): CartItem

    suspend fun incrementCartItem(productId: Int)

    suspend fun decrementCartItem(productId: Int)

    suspend fun deleteCartItem(id: Int): Boolean

    suspend fun clearCart(): Boolean

    fun getTotalPrice(): Flow<Double>
}