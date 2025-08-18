package com.example.nectar.di

import com.example.nectar.data.local.dao.CartItemDao
import com.example.nectar.data.local.dao.ProductDao
import com.example.nectar.data.repository.CartItemRepositoryImpl
import com.example.nectar.data.repository.ProductRepositoryImpl
import com.example.nectar.domain.repository.CartItemRepository
import com.example.nectar.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(productDao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(productDao)
    }

    @Provides
    @Singleton
    fun provideCartItemRepository(cartItemDao: CartItemDao): CartItemRepository {
        return CartItemRepositoryImpl(cartItemDao)
    }


}
