package com.example.shoppi.model

import com.google.gson.annotations.SerializedName

/*

"products": {
    "FW-twg-sweater-1": {
      "brand_name": "twg. official",
      "label": "캐시미어 100% 터틀넥 스웨터",
      "discount_rate": 9,
      "price": 102000,
      "type": "Free",
      "representative_image_url": "https://user-images.githubusercontent.com/20774764/149948250-8968498e-e204-4b35-8d52-8d9aecd1d54a.png",
      "descriptions": [
        {
          "id": "FW-twg-sweater-1-desc-1",
          "image_url": "https://user-images.githubusercontent.com/20774764/154342920-f92e9ce0-4491-427b-9119-97138f102a82.jpg"
        },
        {
          "id": "FW-twg-sweater-1-desc-2",
          "image_url": "https://user-images.githubusercontent.com/20774764/154342942-1956ebb2-cc25-4b71-acc4-702f4a1783c6.jpg"
        }
      ],
      "product_id": "FW-twg-sweater-1"
    }
  }

*/

data class ProductDetail(
    @SerializedName("brand_name") val brandName: String,
    val label: String,
    @SerializedName("discount_rate") val discountRate: Int,
    val price: Int,
    val type: String,
    @SerializedName("representative_image_url") val representativeImageUrl: String,
    val descriptions: List<Description>,
)

data class Description(
    val id: String,
    @SerializedName("image_url") val imageUrl: String,
)