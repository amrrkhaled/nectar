package com.example.nectar.domain.usecase.products

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): Flow<List<Product>> {
        return repository.getFavoriteProducts()
    }
}