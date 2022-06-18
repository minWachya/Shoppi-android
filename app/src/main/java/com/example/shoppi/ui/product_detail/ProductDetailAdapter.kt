package com.example.shoppi.ui.product_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppi.databinding.ItemProductDetailImageBinding
import com.example.shoppi.model.Description
import com.example.shoppi.model.ProductDetail

class ProductDetailAdapter :
    ListAdapter<Description, ProductDetailAdapter.ProductDetailViewHolder>(ProductDetailDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailViewHolder {
        val binding =
            ItemProductDetailImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductDetailViewHolder(private val binding: ItemProductDetailImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(description: Description) {
            binding.imageUrl = description.imageUrl
            binding.executePendingBindings()
        }
    }
}

class ProductDetailDiffCallback : DiffUtil.ItemCallback<Description>() {
    override fun areItemsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem == newItem
    }
}