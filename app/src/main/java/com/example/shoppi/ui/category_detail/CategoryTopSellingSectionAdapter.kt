package com.example.shoppi.ui.category_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppi.databinding.ItemCategoryTopSellingSectionBinding
import com.example.shoppi.model.TopSelling

class CategoryTopSellingSectionAdapter:
    ListAdapter<TopSelling, CategoryTopSellingSectionAdapter.CategoryTopSellingSectionViewHolder>(TopSellingDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CategoryTopSellingSectionViewHolder {
        val binding = ItemCategoryTopSellingSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryTopSellingSectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryTopSellingSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CategoryTopSellingSectionViewHolder(private val binding: ItemCategoryTopSellingSectionBinding): RecyclerView.ViewHolder(binding.root) {

        private val nestedAdapter = CategoryTopSellingItemAdapter()

        init {
            binding.rvCategorySection.adapter = nestedAdapter
        }

        fun bind(topSelling: TopSelling) {
            binding.title = topSelling.title
            binding.executePendingBindings()

            nestedAdapter.submitList(topSelling.categories)
        }
    }
}

class TopSellingDiffCallback: DiffUtil.ItemCallback<TopSelling>() {
    override fun areItemsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem.title.text == newItem.title.text
    }

    override fun areContentsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem == newItem
    }

}