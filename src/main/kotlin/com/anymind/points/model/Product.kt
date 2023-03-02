package com.anymind.points.model

data class Product(
        val id: Int,
        val name: String,
        val price: Double,
        val description: String,
        val imageUrl: String?,
        val category: String,
        val stockCount: Int
)
