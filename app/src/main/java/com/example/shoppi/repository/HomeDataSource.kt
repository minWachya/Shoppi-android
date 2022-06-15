package com.example.shoppi.repository

import com.example.shoppi.model.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}