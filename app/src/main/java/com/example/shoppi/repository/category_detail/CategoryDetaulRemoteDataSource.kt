package com.example.shoppi.repository.category_detail

import com.example.shoppi.model.CategoryDetail
import com.example.shoppi.network.ApiClient

class CategoryDetaulRemoteDataSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}