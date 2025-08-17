package com.example.nectar.di

import android.content.Context
import androidx.room.Room

import com.example.nectar.data.local.AppDatabase
import com.example.nectar.data.local.dao.CartItemDao
import com.example.nectar.data.local.dao.ProductDao
import com.example.nectar.data.prefrences.OnboardingPreferences
import com.example.nectar.data.repository.ProductRepositoryImpl
import com.example.nectar.domain.repository.ProductRepository
import com.example.nectar.ui.navigation.Product
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context,
        // Inject your DAOs here or a CoroutineScope if needed
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "nectar_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase): ProductDao = db.productDao()

    @Provides
    @Singleton
    fun provideCartItemDao(db: AppDatabase): CartItemDao = db.cartItemDao()

    @Provides
    @Singleton
    fun provideOnboardingPreferences(@ApplicationContext context: Context): OnboardingPreferences =
        OnboardingPreferences(context)


}
