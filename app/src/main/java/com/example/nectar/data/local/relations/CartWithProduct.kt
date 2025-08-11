package com.example.nectar.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.nectar.data.local.entity.CartItemEntity
import com.example.nectar.data.local.entity.ProductEntity

data class CartWithProduct(
    @Embedded val cartItem: CartItemEntity,
    @Relation(
        parentColumn = "product_id",
        entityColumn = "id"
    )
    val product: ProductEntity
)