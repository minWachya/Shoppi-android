package com.example.shoppi.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppi.AssetLoader
import com.example.shoppi.network.ApiClient
import com.example.shoppi.repository.category.CategoryRemoteDataSource
import com.example.shoppi.repository.category.CategoryRepository
import com.example.shoppi.repository.category_detail.CategoryDetailRepository
import com.example.shoppi.repository.category_detail.CategoryDetaulRemoteDataSource
import com.example.shoppi.repository.home.HomeAssetDataSource
import com.example.shoppi.repository.home.HomeRepository
import com.example.shoppi.ui.category.CategoryViewModel
import com.example.shoppi.ui.category_detail.CategoryDetailViewModel
import com.example.shoppi.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    // ViewModel 생성하고 반환하기
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // HomeViewModel 타입인지 검사
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                // 의존성 관리: 'Hilt' 라이브러리 사용할 수도 있음
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetaulRemoteDataSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}