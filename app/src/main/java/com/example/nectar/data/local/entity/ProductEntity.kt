package com.example.nectar.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val detail: String,
    val price: Double,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    val category: String,

    val isFavorite: Boolean = false,

    val description: String,

    val nutrition: Map<String, String>,

    val review: Int,
)
