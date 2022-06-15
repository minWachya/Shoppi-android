package com.example.shoppi.ui.common

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.shoppi.R
import java.text.DecimalFormat
import kotlin.math.roundToInt

// 3자리마다 , + 끝에 '원'
@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.unit_discount_currency, decimalFormat.format(price))
}

// 할인률 계산
@BindingAdapter("priceAmount", "discountRate")
fun applyPriceDiscountRate(view: TextView, price: Int, discountRate: Int) {
    val discountPrice = (((100 - discountRate) / 100.0) * price).roundToInt()
    applyPriceFormat(view, discountPrice)
}