package com.example.nectar.domain.repository

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.model.SearchFilter
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

     suspend fun getProducts(): List<Product>
     suspend fun getProductById(id: Int): Product
     suspend fun getProductsByCategory(category: String): List<Product>
     suspend fun searchProducts(filter: SearchFilter): List<Product>
     suspend fun getFavoriteProducts(): Flow<List<Product>>

    suspend fun getExclusiveOffer(): List<Product>
    suspend fun getBestSelling(): List<Product>

    suspend fun toggleFavoriteStatus(productId: Int) : Boolean
}


