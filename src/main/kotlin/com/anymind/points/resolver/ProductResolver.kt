package com.anymind.points.resolver

import com.anymind.points.model.Product
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class ProductResolver() : GraphQLQueryResolver {
    // this method name needs to be same and in the schema
    fun products(): List<Product> {
        val product1 = Product(1, 1.0,"testProduct", "testDescription", "url","category", 10)
        val product2 = Product(21, 10.0,"test2", "testDescription", "url","category", 10)
        return listOf(product1, product2)
    }
}