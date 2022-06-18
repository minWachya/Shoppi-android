package com.example.shoppi.repository.product_detail

import com.example.shoppi.model.ProductDetail
import com.example.shoppi.network.ApiClient

class ProductDetailRemoteDataSource(private val api: ApiClient): ProductDetailDataSource {
    override suspend fun getProductDetail(productId: String): ProductDetail {
        return api.getProductDetail(productId)
    }
}