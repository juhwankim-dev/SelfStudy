package com.ssafy.viewpagerproject.advanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.ssafy.viewpagerproject.databinding.ActivityVpwithTabLayoutBinding
import com.ssafy.viewpagerproject.fragment.FirstFragment
import com.ssafy.viewpagerproject.fragment.SecondFragment

class VPWithTabLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVpwithTabLayoutBinding
    val tabTextList = arrayListOf("여행지", "내 티켓") // 메뉴에 들어갈 이름 (순서대로)
    private val NUM_PAGES = 2 // 페이지 수를 정해둠

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVpwithTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPagerWithTablayout.adapter = ScreenSlidePagerAdapter(this)
        binding.viewPagerWithTablayout.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 뷰페이저와 탭레이아웃을 붙임
        TabLayoutMediator(binding.tabLayoutMenu, binding.viewPagerWithTablayout) { tab, position ->
            tab.text = tabTextList[position]
        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES // 페이지 수 리턴

        override fun createFragment(position: Int): Fragment {
            return when(position){ // 페이지 포지션에 따라 그에 맞는 프래그먼트를 보여줌
                0 -> FirstFragment()
                else -> SecondFragment()
            }
        }
    }
}