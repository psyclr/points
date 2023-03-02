package com.anymind.points.repository

import com.anymind.points.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface OrderRepository : JpaRepository<Order, Int> {
    fun findByUserId(userId: Int): List<Order>
    fun findByDatetimeBetween(startDateTime: LocalDateTime, endDateTime: LocalDateTime) : List<Order>
}
