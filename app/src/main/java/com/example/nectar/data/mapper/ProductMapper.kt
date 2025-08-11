package com.example.nectar.data.mapper


import com.example.nectar.data.local.entity.ProductEntity
import com.example.nectar.domain.model.Product


// Entity → Domain
fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        name = name,
        detail = detail,
        price = price,
        imageUrl = imageUrl,
        categoryId = categoryId,
        isFavorite = isFavorite,
        nutrition = nutrition,
        review = review,
        description = description
    )
}

// Domain → Entity
fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        name = name,
        detail = detail,
        price = price,
        imageUrl = imageUrl,
        categoryId = categoryId,
        isFavorite = isFavorite,
        nutrition = nutrition,
        review = review,
        description = description
    )
}
