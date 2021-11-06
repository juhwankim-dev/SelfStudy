package com.ssafy.viewpagerproject.advanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.ssafy.viewpagerproject.R
import com.ssafy.viewpagerproject.adapter.BannerAdapter
import com.ssafy.viewpagerproject.databinding.ActivityBannerVpactivityBinding

class BannerVPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBannerVpactivityBinding
    private var list = mutableListOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    private var numBanner = 3 // 배너 갯수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBannerVpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bannerViewPager.adapter = BannerAdapter(list)
        binding.bannerViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.textViewTotalBanner.text = numBanner.toString()

        // 현재 몇번째 배너인지 보여주는 숫자를 변경함
        binding.bannerViewPager.apply {
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${position+1}" // position이 0부터 시작해서 +1
                }
            })
        }

        binding.linearLayoutSeeAll.setOnClickListener {
            Toast.makeText(this, "모두 보기 클릭했음", Toast.LENGTH_SHORT).show()
        }
    }
}