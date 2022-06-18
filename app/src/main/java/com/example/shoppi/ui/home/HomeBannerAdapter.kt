package com.example.shoppi.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppi.model.Banner
import com.example.shoppi.databinding.ItemHomeBannerBinding

// ListAdapter: 데이터의 리스트 받아서 순차적으로 viewholder와 바인딩함.
// 레이아웃 유지한 채로 데이터만 업데이트
// BannerDiffCallback: 스크롤 변경됨에 따라서 데이터 변경 확인하고 업데이트
class HomeBannerAdapter(private val viewModel: HomeViewModel): ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {
    private lateinit var binding: ItemHomeBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeBannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(banner: Banner) {
            binding.banner = banner
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }
}

// BannerDiffCallback: 스크롤 변경됨에 따라서 데이터 변경 확인하고 업데이트
// Banner 객체가 같은지 다른지 체크 기준 정하기
class BannerDiffCallback: DiffUtil.ItemCallback<Banner>() {
    // 제품 id 같으면 같은 제품
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }
    // 제품 id도 같을 때 다른 내용들도 모두 같은지?(업데이트 되었을 수도 있으니까)
    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}