package com.anymind.points.model

data class Product(
    val id: Int,
    val price: Double,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val category: String,
    val stockCount: Int
)
