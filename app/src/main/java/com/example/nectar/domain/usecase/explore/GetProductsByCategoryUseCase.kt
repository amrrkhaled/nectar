package com.example.nectar.domain.usecase.explore

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.model.SearchFilter
import com.example.nectar.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsByCategoryUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(category: String): List<Product> {
        return repository.getProductsByCategory(category)
//

    }
}
