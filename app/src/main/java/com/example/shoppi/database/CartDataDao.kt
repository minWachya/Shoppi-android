package com.example.shoppi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppi.model.CartProduct

@Dao
interface CartProductDao {
    // 데이터 추가
    @Insert(onConflict = OnConflictStrategy.REPLACE)  // onConflict: 이미 있는 데이터 중 일부만 바뀔 때
    suspend fun insert(cartProduct: CartProduct)

    // 데이터 요청
    @Query("SELECT * FROM cart_product")
    suspend fun load(): List<CartProduct>
}