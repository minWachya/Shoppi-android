package com.example.shoppi.repository.cart

import com.example.shoppi.model.CartData
import com.example.shoppi.model.CartProduct

interface CartDataSource {
    // 데이터 가져오는 시간 오래 걸리기 때문에 메인 스레드에서 작업하면 X
    suspend fun getCartProduct(): List<CartProduct>
    // 데이터 추가
    suspend fun addCartProduct(cartProduct: CartProduct)
}