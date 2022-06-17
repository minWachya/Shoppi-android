package com.example.shoppi.repository.category_detail

import com.example.shoppi.model.CategoryDetail

class CategoryDetailRepository(private val remoteDataSource: CategoryDetaulRemoteDataSource) {
    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}