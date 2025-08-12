package com.example.nectar.domain.model


data class CartItem(
    val id: Int,
    val productId: Int,
    val name: String? = null,
    val detail: String? = null,
    val price: Double? = null,
    val quantity: Int,
    val imageUrl: String? = null
)