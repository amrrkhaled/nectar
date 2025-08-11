package com.example.nectar.domain.model

data class Product(
    val id: Int,
    val name: String,
    val detail: String,
    val price: Double,
    val imageUrl: String,
    val category: String,
    val isFavorite: Boolean,
    val nutrition: Map<String, String>,
    val review: Int,
    val description: String

)
