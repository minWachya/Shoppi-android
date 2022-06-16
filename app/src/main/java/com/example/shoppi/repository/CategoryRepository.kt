package com.example.shoppi.repository

import com.example.shoppi.model.Category

// ApiClient의 getCategories() 호출하는 클래스
class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {
    // suspend: 코루틴 스코프에서 실행하는지 확인, 코루틴 스코프 아니면 실행 X
    suspend fun getCategories(): List<Category> {   // ViewModel이 호출
        // 원래 이렇게 호출해야 하지만 retrofit 라이브러리가 대신 해줌: 삭제
//        withContext(Dispatchers.IO) {
//            remoteDataSource.getCategories()
//        }
        return remoteDataSource.getCategories()
    }
}