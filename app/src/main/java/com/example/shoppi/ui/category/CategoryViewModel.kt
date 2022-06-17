package com.example.shoppi.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi.model.Category
import com.example.shoppi.repository.category.CategoryRepository
import com.example.shoppi.ui.common.Event
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {
    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> = _items

    // 카테고리 선택 여부 담는 데이터
    private val _openCategoryEvent = MutableLiveData<Event<Category>>()
    val openCategoryEvent: LiveData<Event<Category>> = _openCategoryEvent

        init {  // ViewModel이 생성되는 시점에 loadCategory 호출
        loadCategory()
    }

    fun openCategoryDetail(category: Category) {
        _openCategoryEvent.value = Event(category)
    }

    // 네트워크로 통신은 ui 스레드가 아닌
   private fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}