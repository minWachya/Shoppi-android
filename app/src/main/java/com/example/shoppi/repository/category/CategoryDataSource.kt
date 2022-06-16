package com.example.shoppi.repository.category

import com.example.shoppi.model.Category

// Repository는 DataSource에 데이터 요청
interface CategoryDataSource {
    suspend fun getCategories(): List<Category>
}