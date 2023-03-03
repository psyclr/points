package com.anymind.points.service.intreface

import com.anymind.points.model.User

interface UserService {
    fun getUserById(userId: Int): User
    fun updateUserPoints(userId: Int, pointsToAdd: Double): User
}
