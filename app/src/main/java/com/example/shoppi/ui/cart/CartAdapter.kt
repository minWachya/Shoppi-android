package com.example.shoppi.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppi.databinding.ItemCartBrandBinding
import com.example.shoppi.databinding.ItemCartProductBinding
import com.example.shoppi.model.CartData
import com.example.shoppi.model.CartHeader
import com.example.shoppi.model.CartProduct
import retrofit2.http.Header

private const val VIEW_TYPE_HEADER = 0
private const val VIEW_TYPE_PRODUCT = 1

class CartAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 관리할 데이터
    private val cartData = mutableListOf<CartData>()

    // 2가지 ViewHolder 생성:  viewType 구분 위해 getItemViewType 오버라이드 하기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(ItemCartBrandBinding.inflate(inflater, parent, false))
            else -> ProductViewHolder(ItemCartProductBinding.inflate(inflater, parent, false)) // VIEW_TYPE_PRODUCT
        }
    }

    // 2가지 ViewHolder item 전달
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HeaderViewHolder -> {
                val item = cartData[position] as CartHeader
                holder.bind(item)
            }
            is ProductViewHolder -> {
                val item = cartData[position] as CartProduct
                holder.bind(item)
            }
        }
    }

    override fun getItemCount(): Int = cartData.size

    // ViewType 구분
    override fun getItemViewType(position: Int): Int {
        return when(cartData[position]) {
            is CartHeader -> VIEW_TYPE_HEADER
            is CartProduct -> VIEW_TYPE_PRODUCT
        }
    }

    // cartData에 데이터 넣기
    fun submitHeaderAndProductList(items: List<CartProduct>) {
        val itemGroups = items.groupBy { it.brandName } // 상품 상세 데이터를 브랜드명으로 구분
        val data = mutableListOf<CartData>()
        itemGroups.entries.forEach { entry ->
            val header = CartHeader(entry.key)
            data.add(header)
            data.addAll(entry.value)
        }
        cartData.addAll(data)
        notifyItemRangeInserted(cartData.size, data.size)    // 아이템이 추가되는 position, 추가된 아이템 갯수
    }

    class HeaderViewHolder(private val binding: ItemCartBrandBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cartHeader: CartHeader) {
            binding.header = cartHeader
            binding.executePendingBindings()
        }
    }

    class ProductViewHolder(private val binding: ItemCartProductBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cartProduct: CartProduct) {
            binding.product = cartProduct
            binding.executePendingBindings()
        }
    }
}