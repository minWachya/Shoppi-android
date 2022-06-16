package com.example.shoppi.ui.common

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun updateVisible(view: View, isVisible: Boolean) {
    view.visibility = if(isVisible) View.VISIBLE else View.GONE
}