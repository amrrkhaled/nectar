package com.example.nectar.data.repository

import com.example.nectar.data.local.dao.CartItemDao
import com.example.nectar.data.mapper.toDomain
import com.example.nectar.data.mapper.toEntity
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.CartItemView
import com.example.nectar.domain.repository.CartItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartItemRepositoryImpl @Inject constructor(
    private val cartItemDao: CartItemDao
) : CartItemRepository {

    // Implement the methods from CartItemRepository interface here
    // For example:

    override fun getCartItems(): Flow<List<CartItemView>> {
        return cartItemDao.getCartWithProducts()
            .map { list ->
                list.map { it.toDomain() }
            }
    }


    override suspend fun addCartItem(cartItem: CartItem): CartItem {

        val entity = cartItem.toEntity()
        cartItemDao.insertOrIncrement(entity)
        return cartItem
    }

    override suspend fun updateCartItem(cartItem: CartItem): CartItem {
        val entity = cartItem.toEntity()
        cartItemDao.updateQuantity(entity.productId, entity.quantity)
        return cartItem
    }

    override suspend fun incrementCartItem(productId: Int) {
        cartItemDao.incrementQuantity(productId)
    }

    override suspend fun decrementCartItem(productId: Int) {
        cartItemDao.decrementQuantity(productId)
    }

    override fun getTotalPrice(): Flow<Double> {
        return cartItemDao.getTotalPrice()
    }

    override suspend fun deleteCartItem(id: Int): Boolean {
        return try {
            cartItemDao.removeFromCart(id)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun clearCart(): Boolean {
        return try {
            cartItemDao.clearCart()
            true
        } catch (e: Exception) {
            false
        }
    }
}