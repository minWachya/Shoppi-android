package com.example.shoppi.model

import com.google.gson.annotations.SerializedName

/*
"title": {
    "text": "minWachya님, 이런 상품\n어때요?",
    "icon_url": "https://user-images.githubusercontent.com/61674991/173049282-bbae9702-4ef6-4cc8-8671-22bf64c2da47.png"
},
 */

data class Title(
    val text: String,
    @SerializedName("icon_url") val iconUrl: String?
)
