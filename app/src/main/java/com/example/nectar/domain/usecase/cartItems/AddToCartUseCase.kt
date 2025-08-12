package com.example.nectar.domain.usecase.cartItems

import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.repository.CartItemRepository
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(
    private val repository: CartItemRepository
) {
    suspend operator fun invoke(cartItem: CartItem) {
        repository.addCartItem(cartItem)
    }
}