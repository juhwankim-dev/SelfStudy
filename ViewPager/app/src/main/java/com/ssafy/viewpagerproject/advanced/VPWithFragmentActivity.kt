package com.ssafy.viewpagerproject.advanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ssafy.viewpagerproject.databinding.ActivityVpwithFragmentBinding
import com.ssafy.viewpagerproject.fragment.FirstFragment
import com.ssafy.viewpagerproject.fragment.SecondFragment

class VPWithFragmentActivity : AppCompatActivity() {
    private val NUM_PAGES = 2 // 페이지 수를 정해둠
    private lateinit var binding: ActivityVpwithFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVpwithFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPagerWithFragment.adapter = ScreenSlidePagerAdapter(this)
        binding.viewPagerWithFragment.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.springDotsIndicator.setViewPager2(binding.viewPagerWithFragment)
    }

    override fun onBackPressed() {
        if (binding.viewPagerWithFragment.currentItem == 0) {
            // 사용자가 첫 번째 페이지에서 뒤로가기 버튼을 누르면 finish 하도록 하고
            super.onBackPressed()
        } else {
            // 그렇지 않으면 이전 페이지로 이동하게 한다.
            binding.viewPagerWithFragment.currentItem = binding.viewPagerWithFragment.currentItem - 1
        }
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