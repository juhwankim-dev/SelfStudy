package com.ssafy.viewpagerproject.advanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.ssafy.viewpagerproject.R
import com.ssafy.viewpagerproject.adapter.AnimationAdapter
import com.ssafy.viewpagerproject.databinding.ActivityVpwithIndicatorBinding

class VPWithIndicatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVpwithIndicatorBinding

    private var list = mutableListOf(R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVpwithIndicatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* 여백, 너비에 대한 정의 */
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimens.xml 파일 안에 크기를 정의해두었다. (200dp)
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimens.xml 파일이 없으면 생성해야함 (50dp)
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.viewPagerWithIndicator.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        binding.viewPagerWithIndicator.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
        binding.viewPagerWithIndicator.adapter = AnimationAdapter(list) // 어댑터 생성 (Animation꺼 재활용 했습니다)
        binding.viewPagerWithIndicator.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

        binding.springDotsIndicator.setViewPager2(binding.viewPagerWithIndicator) // indicator 설정
    }
}