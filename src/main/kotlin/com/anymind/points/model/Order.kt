package com.anymind.points.model

import java.time.LocalDateTime

data class Order(
    val id: Int,
    val userId: Int,
    val products: List<Product>,
    val totalPrice: Double,
    val paymentMethod: PaymentMethod,
    val datetime: LocalDateTime
) {
    fun calculateTotalPrice(): Double {
        val productsTotalPrice = products.sumOf { it.price }
        val paymentMethodPrice = productsTotalPrice * paymentMethod.priceModifier
        val commissionFee = paymentMethodPrice * paymentMethod.commissionFee
        return paymentMethodPrice + commissionFee
    }

    fun calculatePoints(): Double {
        val productsTotalPrice = products.sumOf { it.price }
        return productsTotalPrice * paymentMethod.points
    }
}
