package com.example.nectar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.nectar.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insert(product: ProductEntity)

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertAll(products: List<ProductEntity>)

     @Query("DELETE FROM products")
     suspend fun deleteAll()
     @Transaction
     @Query("SELECT * FROM products WHERE id = :productId")
     suspend fun getProductWithDetail(productId: Int): ProductEntity

     @Query("SELECT * FROM products")
     suspend fun getAllProducts(): List<ProductEntity>

     @Query("SELECT * FROM products WHERE name LIKE '%' || :query || '%' COLLATE NOCASE")
     suspend fun searchProducts(query: String): List<ProductEntity>

     @Query("SELECT * FROM products WHERE isFavorite = 1")
     suspend fun getFavoriteProducts(): List<ProductEntity>

     @Query("SELECT * FROM products WHERE category_id = :categoryId")
     suspend fun getProductsByCategory(categoryId: Int): List<ProductEntity>
}