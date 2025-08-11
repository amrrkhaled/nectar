package com.example.nectar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Transaction
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.nectar.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDao {

     @Query("SELECT COUNT(*) FROM products")
     suspend fun countProducts(): Int

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

     @RawQuery(observedEntities = [ProductEntity::class])
     suspend fun searchProducts(query: SupportSQLiteQuery): List<ProductEntity>

     @Query("SELECT * FROM products WHERE isFavorite = 1")
     suspend fun getFavoriteProducts(): List<ProductEntity>

     @Query("SELECT * FROM products WHERE category = :categoryName")
     suspend fun getProductsByCategory(categoryName: String): List<ProductEntity>
}