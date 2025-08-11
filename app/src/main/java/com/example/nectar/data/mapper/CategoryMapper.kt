package com.example.nectar.data.mapper

import com.example.nectar.data.local.entity.CategoryEntity
import com.example.nectar.domain.model.Category

fun CategoryEntity.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}
