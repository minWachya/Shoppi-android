package com.example.shoppi.model

import com.google.gson.annotations.SerializedName

/*
{
      "background_image_url": "https://user-images.githubusercontent.com/61674991/173049405-c47ae022-a536-4f49-b151-e8f3aa82ab9a.png",
      "badge": {
        "label": "기획전",
        "background_color": "#52514d"
      },
      "label": "따스한 겨울\n준비하기",
      "product_detail": {
        "brand_name": "twg.official",
        "label": "캐시미어 100% 터틀넥 스웨터",
        "discount_rate": 9,
        "price": 102000,
        "thumbnail_image_url": "https://user-images.githubusercontent.com/61674991/173049400-b2f06b08-5cc3-46c9-bc95-c5e1b0e2e2ec.png",
        "product_id": "FW-twg-sweater-1"
      }
    },
*/

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
    @SerializedName("product_detail") val productDetail: Product
)

data class BannerBadge(
    val label: String,
    @SerializedName("background_color") val backgroundColor: String
)