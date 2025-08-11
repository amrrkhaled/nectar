package com.example.nectar.data.local.util

import com.example.nectar.data.local.dao.CartItemDao
import com.example.nectar.data.local.dao.CategoryDao
import com.example.nectar.data.local.dao.ProductDao
import com.example.nectar.data.local.entity.CategoryEntity
import javax.inject.Inject

class DatabaseSeeder @Inject constructor(
    private val productDao: ProductDao,
    private val cartItemDao: CartItemDao,
    private val categoryDao: CategoryDao
) {

    suspend fun seed() {
        // Delete all existing data
        cartItemDao.deleteAll()
        productDao.deleteAll()
        categoryDao.deleteAll()
        listOf<CategoryEntity>(
            CategoryEntity(1, "Fruits", "Fresh and healthy fruits"),
            CategoryEntity(2, "Vegetables", "Organic and fresh vegetables"),
            CategoryEntity(3, "Dairy", "Milk, cheese, and other dairy products"),
            CategoryEntity(4, "Bakery", "Freshly baked bread and pastries"),
            CategoryEntity(5, "Beverages", "Juices, sodas, and other drinks")
        ).let { categoryDao.insertAll(it) }
        // Insert categories





    }
}
