package com.example.shoppi.ui.product_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi.model.ProductDetail
import com.example.shoppi.repository.product_detail.ProductDetailRepository
import kotlinx.coroutines.launch


class ProductDetailViewModel(private val productDetailRepository: ProductDetailRepository) :
    ViewModel() {
    private val _productDetail = MutableLiveData<ProductDetail>()
    val productDetail: LiveData<ProductDetail> = _productDetail

    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            val productDetail = productDetailRepository.getProductDetail(productId)
            _productDetail.value = productDetail
        }
    }

}