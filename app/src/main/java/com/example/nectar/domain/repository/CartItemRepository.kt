package com.example.nectar.domain.repository

import com.example.nectar.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartItemRepository {

    fun getCartItems(): Flow<List<CartItem>>

    suspend fun addCartItem(cartItem: CartItem): CartItem

    suspend fun updateCartItem(cartItem: CartItem): CartItem

    suspend fun deleteCartItem(id: Int): Boolean

    suspend fun clearCart(): Boolean
}