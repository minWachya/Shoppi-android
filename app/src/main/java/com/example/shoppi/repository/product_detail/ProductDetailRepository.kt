package com.example.shoppi.repository.product_detail

import com.example.shoppi.model.Product

class ProductDetailRepository (private val remoteDataSource: ProductDetailRemoteDataSource) {
    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}