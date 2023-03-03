package com.anymind.points.service

import com.anymind.points.model.Product
import com.anymind.points.repository.ProductRepository
import com.anymind.points.service.intreface.ProductService
import java.util.*

class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {
    override fun getProducts(): List<Product> {
        return productRepository.findAll()
    }

    override fun getProductById(productId: Int): Optional<Product> {
        return productRepository.findById(productId)
    }

    override fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun updateProduct(productId: Int, updatedProduct: Product): Product {
        val productToUpdate = productRepository.findById(productId)

        val updatedProductCopy = updatedProduct.copy(id = productId)
        return productRepository.save(updatedProductCopy)
    }

    override fun deleteProduct(productId: Int) {
        productRepository.deleteById(productId)
    }
}
