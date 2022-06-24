package com.example.shoppi.repository.cart

import com.example.shoppi.database.CartProductDao
import com.example.shoppi.model.CartProduct

class CartLocalDataSource(private val dao: CartProductDao): CartDataSource {
    // 데이터 베이스와 통신
    override suspend fun getCartProduct(): List<CartProduct> {
        return dao.load()
    }
    // 데이터 추가
    override suspend fun addCartProduct(cartProduct: CartProduct) {
        dao.insert(cartProduct)
    }
}