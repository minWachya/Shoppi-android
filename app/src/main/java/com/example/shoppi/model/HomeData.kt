package com.example.shoppi.model

import com.google.gson.annotations.SerializedName

// home.json과 같은 데이터 구조
// 변수명은 json의 key값과 같게
// 다르게 하고 싶다면 @SerializedName 어노테이션 사용
data class HomeData(
    val title: Title,
    @SerializedName("top_banners") val topBanners: List<Banner>,
)
