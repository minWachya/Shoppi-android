package com.example.shoppi.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppi.AssetLoader
import com.example.shoppi.repository.HomeAssetDataSource
import com.example.shoppi.repository.HomeRepository
import com.example.shoppi.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    // HomeViewModel 생성하고 반환하기
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // HomeViewModel 타입인지 검사
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            // 의존성 관리: 'Hilt' 라이브러리 사용할 수도 있음
            val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            return HomeViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}