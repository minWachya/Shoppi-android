package com.example.shoppi.repository.home

import com.example.shoppi.model.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}