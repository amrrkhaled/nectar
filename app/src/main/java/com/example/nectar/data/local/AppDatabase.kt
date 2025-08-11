package com.example.nectar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nectar.data.local.converters.Converter

import com.example.nectar.data.local.dao.CartItemDao
import com.example.nectar.data.local.dao.CategoryDao
import com.example.nectar.data.local.dao.ProductDao
import com.example.nectar.data.local.entity.CartItemEntity
import com.example.nectar.data.local.entity.CategoryEntity
import com.example.nectar.data.local.entity.ProductEntity

@Database(
    entities = [ProductEntity::class, CartItemEntity::class , CategoryEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productDao(): ProductDao
    abstract fun cartItemDao(): CartItemDao
    abstract fun categoryDao(): CategoryDao
}