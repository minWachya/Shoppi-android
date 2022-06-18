package com.example.shoppi.repository.product_detail

import com.example.shoppi.model.ProductDetail

class ProductDetailRepository (private val remoteDataSource: ProductDetailRemoteDataSource) {
    suspend fun getProductDetail(productId: String): ProductDetail {
        return remoteDataSource.getProductDetail(productId)
    }
}