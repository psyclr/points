package com.anymind.points.model

import java.time.LocalDateTime
import java.util.*

data class User(
        val id: UUID,
        val name: String,
        val email: String,
        val password: String,
        val created: LocalDateTime = LocalDateTime.now(),
        val balance: Double
)
