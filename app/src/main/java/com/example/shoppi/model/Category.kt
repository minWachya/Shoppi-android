package com.example.shoppi.model

import com.google.gson.annotations.SerializedName

/*
"categories": [
    {
      "category_id": "fashion-female",
      "label": "여성패션",
      "thumbnail_image_url": "https://user-images.githubusercontent.com/61674991/173981555-6f917bc8-2d29-4a8b-9b39-9541b5d7b595.jpg",
      "updated": false
    },
    {
      "category_id": "fashion-male",
      "label": "남성패션",
      "thumbnail_image_url": "https://user-images.githubusercontent.com/61674991/173981548-5fd817a3-9ef0-4c66-a855-9a396162b533.jpg",
      "updated": false
    }
    ...
    ]
}
*/

data class Category(
    @SerializedName("category_id") val categoryId: String,
    val label: String,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String,
    val updated: Boolean
    )
