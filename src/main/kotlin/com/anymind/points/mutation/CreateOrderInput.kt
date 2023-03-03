package com.anymind.points.mutation

data class CreateOrderInput(
    val userId: Int,
    val productIds: List<Int>
)


