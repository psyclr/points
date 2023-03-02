package com.anymind.points.service

import com.anymind.points.model.Product
import java.util.*

interface ProductService {
    fun getProducts(): List<Product>
    fun getProductById(productId: Int): Optional<Product>
    fun createProduct(product: Product): Product
    fun updateProduct(productId: Int, updatedProduct: Product): Product
    fun deleteProduct(productId: Int)
}
