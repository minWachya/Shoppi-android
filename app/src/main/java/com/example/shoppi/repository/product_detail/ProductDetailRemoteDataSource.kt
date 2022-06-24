package com.example.shoppi.repository.product_detail

import com.example.shoppi.model.Product
import com.example.shoppi.network.ApiClient

class ProductDetailRemoteDataSource(private val api: ApiClient): ProductDetailDataSource {
    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}