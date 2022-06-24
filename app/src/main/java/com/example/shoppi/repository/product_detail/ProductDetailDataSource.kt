package com.example.shoppi.repository.product_detail

import com.example.shoppi.model.Product

interface ProductDetailDataSource {
    suspend fun getProductDetail(productId: String): Product
}