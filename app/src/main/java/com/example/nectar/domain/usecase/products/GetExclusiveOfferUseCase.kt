package com.example.nectar.domain.usecase.products

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class GetExclusiveOfferUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> {
        return repository.getExclusiveOffer()
    }
}