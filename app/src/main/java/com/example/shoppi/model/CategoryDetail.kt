package com.example.shoppi.model

import com.google.gson.annotations.SerializedName

/*
"fashion_female": {
    "top_selling": {
      "title": {
        "text": "인기상품"
      },
      "categories": [
        {
          "category_id": "fashion_jacket",
          "label": "자켓",
          "thumbnail_image_url": "https://user-images.githubusercontent.com/61674991/174230345-26b30d31-3380-4f83-a84e-34d894197622.png",
          "updated": true
        }
        // ...
      ]
    },
    "promotions" : {
      "title" : {
        "text" : "추천상품"
      },
      "items" : [
        {
          "label": "[19차 리오더] 페이크 레더 숏 데일리 자켓 블랙",
          "discount_rate": 19,
          "price": 98000,
          "representative_image_url": "https://user-images.githubusercontent.com/61674991/174230355-60546034-4fe2-4560-a003-041b3fa59ce1.png",
          "product_id": "jacket_1"
        },
        // ...
      ]
    }
  }
*/

data class CategoryDetail(
    @SerializedName("top_selling") val topSelling: TopSelling,
    val promotions: Promotion,
)

data class TopSelling(
    val title: Title,
    val categories: List<Category>
)

data class Promotion(
    val title: Title,
    val items: List<Product>
)