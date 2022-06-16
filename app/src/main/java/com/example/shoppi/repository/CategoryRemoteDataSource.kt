package com.example.shoppi.repository

import com.example.shoppi.model.Category
import com.example.shoppi.network.ApiClient

// CategoryDataSource를 구현한 객체
class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}