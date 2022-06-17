package com.example.shoppi.repository.category_detail

import com.example.shoppi.model.CategoryDetail

interface CategoryDetailDataSource {
    suspend fun getCategoryDetail(): CategoryDetail
}