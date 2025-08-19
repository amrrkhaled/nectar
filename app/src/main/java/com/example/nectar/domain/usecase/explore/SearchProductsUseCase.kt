package com.example.nectar.domain.usecase.explore

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.model.SearchFilter
import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(filter: SearchFilter): List<Product> {
        return repository.searchProducts(filter)

        }
    }
