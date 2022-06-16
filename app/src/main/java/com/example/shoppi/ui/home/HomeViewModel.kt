package com.example.shoppi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppi.model.Banner
import com.example.shoppi.model.Title
import com.example.shoppi.repository.home.HomeRepository

// home 화면 그리는 데 필요한 데이터의 state holder 역할
class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {
    // 외부 접근 불가 변수: _로 시작
    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    init {
        loadHomeDate()
    }

    // 데이터 요청
    private fun loadHomeDate() {
        val homeData = homeRepository.getHomeData()
        homeData?.let { homeData ->
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
        }
    }
}