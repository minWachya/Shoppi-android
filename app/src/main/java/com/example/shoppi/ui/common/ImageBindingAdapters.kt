package com.example.shoppi.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.shoppi.GlideApp

// 커스텀 속성 적용

// 커스텀 속성 이름: imageUrl
// 커스첨 속성 사용 시 호출될 로직: loadImage(~)
// 첫 번째 인자: 이 속성 호출 가능한 View
// 두 번째 인자: 커스텀 속성에 할당할 수 있는 값의 타입
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}

@BindingAdapter("circleImageUrl")
fun loadCircleImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .circleCrop()
            .into(view)
    }
}