package com.example.nectar.domain.repository

import com.example.nectar.domain.model.Product
import com.example.nectar.domain.model.SearchFilter

interface ProductRepository {

     suspend fun getProducts(): List<Product>
     suspend fun getProductById(id: Int): Product?
     suspend fun getProductsByCategory(category: String): List<Product>
     suspend fun searchProducts(filter: SearchFilter): List<Product>

}