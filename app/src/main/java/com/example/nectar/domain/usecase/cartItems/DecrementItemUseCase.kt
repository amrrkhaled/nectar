package com.example.nectar.domain.usecase.cartItems

import com.example.nectar.domain.repository.CartItemRepository
import javax.inject.Inject

class DecrementItemUseCase @Inject constructor(
    private val repository: CartItemRepository
) {
    suspend operator fun invoke(productId:Int) {
        repository.decrementCartItem(productId)
    }
}