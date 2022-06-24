package com.example.shoppi.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi.model.CartProduct
import com.example.shoppi.repository.cart.CartRepository
import kotlinx.coroutines.launch

class CartViewModel(private val cartRepository: CartRepository): ViewModel() {

    private val _items = MutableLiveData<List<CartProduct>>()
    val items: LiveData<List<CartProduct>> = _items

    init {
        loadCartProduct()
    }

    private fun loadCartProduct() {
        viewModelScope.launch {
            _items.value =cartRepository.getCartProduct()
        }
    }
}