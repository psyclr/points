package com.anymind.points.service.intreface

import com.anymind.points.model.Order
import com.anymind.points.model.PaymentMethod
import com.anymind.points.model.Product
import java.time.LocalDateTime

interface OrderService {
    fun getOrdersForUser(userId: Int): List<Order>
    fun getOrdersByDateRange(startDateTime: LocalDateTime, endDateTime: LocalDateTime): List<Order>
    fun updateOrder(orderId: Int, updatedOrder: Order): Order
    fun cancelOrder(orderId: Int)
    fun createOrder(
        userId: Int,
        products: List<Product>,
        paymentMethod: PaymentMethod,
        totalPrice: Double
    ): Order
}
