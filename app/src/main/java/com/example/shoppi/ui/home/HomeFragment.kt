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
import com.example.shoppi.ui.common.ViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment() {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // attachToRoot: 바로 루트 뷰에 추가할 것인가: false
        // 액티비티가 모두 구성된 이후에 인플레이트 되어야 하기 때문에 생성되는 시점 늦추기 위해 false
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        // 데이터 변경 시 어떤 처리하리는 Fragemnt가 구현
        viewModel.title.observe(viewLifecycleOwner) { title ->
            // view 업데이트
            toolbarTitle.text = title.text
            GlideApp.with(this@HomeFragment)
                .load(title.iconUrl)
                .into(toolbarIcon)
        }
        viewpager.adapter = HomeBannerAdapter().apply {
            viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                submitList(banners)
            }
        }
        // dp -> px
        val pageWidth = resources.getDimension(R.dimen.viewpage_item_width)
        val pageMargin = resources.getDimension(R.dimen.viewpage_item_margin)
        val screenWidth = resources.displayMetrics.widthPixels
        // 얼만큼 살짝 보일지 계산
        viewpager.offscreenPageLimit = 3
        val offset = screenWidth - pageWidth - pageMargin
        viewpager.setPageTransformer { page, position ->
            page.translationX = position * -offset
        }
        TabLayoutMediator(viewpagerIndicator, viewpager) { tab, position -> }.attach()

    }
}