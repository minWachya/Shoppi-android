package com.example.shoppi.repository.product_detail

import com.example.shoppi.model.ProductDetail

interface ProductDetailDataSource {
    suspend fun getProductDetail(productId: String): ProductDetail
}