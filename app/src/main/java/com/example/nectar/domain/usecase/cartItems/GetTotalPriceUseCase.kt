package com.example.nectar.domain.usecase.cartItems

import com.example.nectar.domain.repository.CartItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTotalPriceUseCase @Inject constructor(
    private val repository: CartItemRepository
) {
    operator fun invoke(): Flow<Double> {
        return repository.getTotalPrice()
    }
}