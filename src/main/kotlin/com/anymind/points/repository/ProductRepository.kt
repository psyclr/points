package com.anymind.points.repository

import com.anymind.points.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int>
