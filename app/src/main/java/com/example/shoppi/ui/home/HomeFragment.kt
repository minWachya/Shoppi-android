package com.example.shoppi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.shoppi.*
import com.example.shoppi.databinding.FragmentHomeBinding
import com.example.shoppi.ui.common.ViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment() {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        setToolbar()
        setTopBanners()

    }

    private fun setToolbar() {
        // 데이터 변경 시 어떤 처리하리는 Fragemnt가 구현
        viewModel.title.observe(viewLifecycleOwner) { title ->
            // view 업데이트
            binding.title = title
        }
    }

    private fun setTopBanners() {
        with(binding.viewpagerHomeBanner) {
            adapter = HomeBannerAdapter().apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }
            // dp -> px
            val pageWidth = resources.getDimension(R.dimen.viewpage_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpage_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            // 얼만큼 살짝 보일지 계산
            offscreenPageLimit = 3
            val offset = screenWidth - pageWidth - pageMargin
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            TabLayoutMediator(binding.viewpagerHomeBannerIndicator,
                this) { tab, position -> }.attach()

        }
    }

}