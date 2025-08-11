package com.example.nectar.domain.model

data class SearchFilter(

    val queryText: String,
    val category: String? = null,
    val minPrice: Double? = null,
    val maxPrice: Double? = null
)
