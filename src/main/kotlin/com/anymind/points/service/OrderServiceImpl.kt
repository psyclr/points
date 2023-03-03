package com.anymind.points.service

import com.anymind.points.exception.InsufficientBalanceException
import com.anymind.points.model.Order
import com.anymind.points.model.PaymentMethod
import com.anymind.points.model.Product
import com.anymind.points.repository.OrderRepository
import com.anymind.points.service.intreface.OrderService
import com.anymind.points.service.intreface.UserService
import java.time.LocalDateTime

class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val userService: UserService
) : OrderService {
    override fun createOrder(
        userId: Int,
        products: List<Product>,
        paymentMethod: PaymentMethod,
        totalPrice: Double
    ): Order {
        val order = Order(
            id = 0,
            userId = userId,
            products = products,
            paymentMethod = paymentMethod,
            datetime = LocalDateTime.now(),
            totalPrice = totalPrice
        )

        val user = userService.getUserById(userId)
        val pointsToAdd = order.calculatePoints()

        if (totalPrice > user.balance) {
            throw InsufficientBalanceException("User has insufficient balance to make this purchase")
        }

        userService.updateUserPoints(userId, pointsToAdd)

        return orderRepository.save(order)
    }

    override fun getOrdersByDateRange(
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): List<Order> {
        return orderRepository.findByDatetimeBetween(startDateTime, endDateTime)
    }

    override fun getOrdersForUser(userId: Int): List<Order> {
        TODO("Not yet implemented")
    }

    override fun updateOrder(orderId: Int, updatedOrder: Order): Order {
        TODO("Not yet implemented")
    }

    override fun cancelOrder(orderId: Int) {
        TODO("Not yet implemented")
    }
}
