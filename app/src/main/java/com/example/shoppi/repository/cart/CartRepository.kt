package com.example.shoppi.repository.cart

import com.example.shoppi.model.CartProduct
import com.example.shoppi.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartRepository(
    private val localDataSource: CartLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
    suspend fun addCartProduct(product: Product) {
        withContext(ioDispatcher) {
            val cartProduct = CartProduct(
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName ?: "",
                thumbnailImageUrl = product.thumbnailImageUrl ?: "",
                type = product.type ?: "",
                count = 1
            )
            localDataSource.addCartProduct(cartProduct)
        }
    }


    suspend fun getCartProduct(): List<CartProduct> {
        return withContext(ioDispatcher) {
            localDataSource.getCartProduct()
        }
    }
}