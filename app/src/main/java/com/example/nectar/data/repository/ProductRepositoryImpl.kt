package com.example.nectar.data.repository

import android.provider.SyncStateContract.Helpers.insert
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.nectar.data.local.dao.ProductDao
import com.example.nectar.data.mapper.toDomain
import com.example.nectar.data.mapper.toEntity
import com.example.nectar.domain.model.Product
import com.example.nectar.domain.model.SearchFilter
import com.example.nectar.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.collections.map

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductRepository {

    override suspend fun searchProducts(filter: SearchFilter): List<Product> {
        val sqlBuilder = StringBuilder()
        val args = mutableListOf<Any>()

        sqlBuilder.append("SELECT * FROM product WHERE name LIKE ?")
        args.add("%${filter.queryText}%")

        filter.category?.let {
            sqlBuilder.append(" AND category = ?")
            args.add(it)
        }
        filter.minPrice?.let {
            sqlBuilder.append(" AND price >= ?")
            args.add(it)
        }
        filter.maxPrice?.let {
            sqlBuilder.append(" AND price <= ?")
            args.add(it)
        }

        val query = SimpleSQLiteQuery(sqlBuilder.toString(), args.toTypedArray())
        val productEntities = productDao.searchProducts(query)
        return productEntities.map { it.toDomain() }
    }

    override suspend fun getProducts(): List<Product> {
        val productEntities = productDao.getAllProducts()
        return productEntities.map { it.toDomain() }
    }

    override suspend fun getProductById(id: Int): Product {
        val productEntity = productDao.getProductWithDetail(id)
        return productEntity.toDomain()
    }

    override suspend fun getProductsByCategory(category: String): List<Product> {
        val productEntities = productDao.getProductsByCategory(category)
        return productEntities.map { it.toDomain() }
    }

    override suspend fun getFavoriteProducts(): Flow<List<Product>> {
        val productEntities = productDao.getFavoriteProducts()
        return productEntities.map { list ->
            list.map { it.toDomain() }
        }
    }
    override suspend fun getExclusiveOffer(): List<Product> {
        val productEntities = productDao.getProductsUnderPrice(2.0)
        return productEntities.map { it.toDomain() }
    }

    override suspend fun getBestSelling(): List<Product> {
        val productEntities = productDao.getProductsUnderPrice(5.0)
        return productEntities.map { it.toDomain() }
    }

    override suspend fun toggleFavoriteStatus(productId: Int) : Boolean {
        // Get the current product
        val product = getProductById(productId)

        // Invert the favorite status
        val newProduct = product.copy(isFavorite = !product.isFavorite)

        // Save the updated product
        productDao.insert(newProduct.toEntity())
        return newProduct.isFavorite
    }


}