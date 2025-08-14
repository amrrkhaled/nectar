package com.example.nectar.data.mapper

import com.example.nectar.data.local.entity.CartItemEntity
import com.example.nectar.data.local.relations.CartWithProduct
import com.example.nectar.domain.model.CartItem
import com.example.nectar.domain.model.CartItemView


fun CartWithProduct.toDomain(): CartItemView {
    return CartItemView(
        id = cartItem.id,          // cart entry id
        productId = cartItem.productId,
        name = product.name,
        detail = product.detail,
        price = product.price,
        quantity = cartItem.quantity,
        imageUrl = product.imageUrl
    )
}

fun CartItem.toEntity(): CartItemEntity {
    return CartItemEntity(
        id = id,
        productId = productId,
        quantity = quantity,
        addedAt = System.currentTimeMillis()
    )
}




