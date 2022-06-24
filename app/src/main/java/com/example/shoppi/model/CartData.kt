package com.example.shoppi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class CartData

data class CartHeader(
    val brandName: String
): CartData()

@Entity(
    tableName = "cart_product"
)
data class CartProduct(
    @PrimaryKey @ColumnInfo(name = "product_id") val productId: String,
    val label: String,
    val price: Int,
    @ColumnInfo(name = "brand_name") val brandName: String,
    @ColumnInfo(name = "thumbnail_image_url") val thumbnailImageUrl: String,
    val type: String,
    val count: Int
): CartData()
