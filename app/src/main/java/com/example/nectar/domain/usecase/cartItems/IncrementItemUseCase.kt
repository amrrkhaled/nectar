package com.example.nectar.domain.usecase.cartItems

import com.example.nectar.domain.model.CartItemView
import com.example.nectar.domain.repository.CartItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IncrementItemUseCase @Inject constructor(
    private val repository: CartItemRepository
) {
    suspend operator fun invoke(productId:Int) {
        repository.incrementCartItem(productId)
    }
}