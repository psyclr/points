package com.anymind.points.model

data class PaymentMethod(
        val name: String,
        val priceModifier: Double,
        val points: Double,
        val commissionFee: Double = 0.0
)
