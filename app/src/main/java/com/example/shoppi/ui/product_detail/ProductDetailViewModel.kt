package com.example.shoppi.ui.product_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi.model.Product
import com.example.shoppi.repository.cart.CartRepository
import com.example.shoppi.repository.product_detail.ProductDetailRepository
import com.example.shoppi.ui.common.Event
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository
    ) : ViewModel() {

    private val _productDetail = MutableLiveData<Product>()
    val productDetail: LiveData<Product> = _productDetail

    // 버튼의 이벤트 상태 저장함
    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent: LiveData<Event<Unit>> = _addCartEvent

    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            val productDetail = productDetailRepository.getProductDetail(productId)
            _productDetail.value = productDetail
        }
    }

    fun addCart(product: Product) {
        viewModelScope.launch {
            cartRepository.addCartProduct(product)
            _addCartEvent.value = Event(Unit)
        }
    }

}