package com.example.nectar.domain.model


data class CartItemView(
    val id: Int,
    val productId: Int,
    val name: String,
    val detail: String,
    val price: Double,
    val quantity: Int,
    val imageUrl: String
)