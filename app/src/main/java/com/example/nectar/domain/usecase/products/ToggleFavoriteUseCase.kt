package com.example.nectar.domain.usecase.products

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id : Int)  {
        repository.toggleFavoriteStatus(id)
    }
}