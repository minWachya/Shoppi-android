package com.example.shoppi.ui.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.BindingConversion

// 해당 어노테이션을 붙인 함수의 매개변수의 타입이 xml에서 적혀진 타입과 같다면
// 자동으로 해당 함수가 호출
@BindingConversion
fun convertToColorDrawable(color: String): Drawable {
    return ColorDrawable(Color.parseColor(color))
}