package com.ssafy.viewpagerproject.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.ssafy.viewpagerproject.R
import com.ssafy.viewpagerproject.adapter.AnimationAdapter
import com.ssafy.viewpagerproject.databinding.ActivityAnimationVpactivityBinding

class AnimationVPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationVpactivityBinding
    private var list = mutableListOf(R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4)
    private val MIN_SCALE = 0.85f // 뷰가 몇퍼센트로 줄어들 것인지
    private val MIN_ALPHA = 0.5f // 어두워지는 정도를 나타낸 듯 하다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationVpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animationViewPagerIcon.adapter = AnimationAdapter(list)
        binding.animationViewPagerIcon.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.animationViewPagerIcon.setPageTransformer(ZoomOutPageTransformer())
    }

    /* 공식문서에 있는 코드 긁어온거임 */
    inner class ZoomOutPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                val pageHeight = height
                when {
                    position < -1 -> { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        alpha = 0f
                    }
                    position <= 1 -> { // [-1,1]
                        // Modify the default slide transition to shrink the page as well
                        val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                        val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        val horzMargin = pageWidth * (1 - scaleFactor) / 2
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2
                        } else {
                            horzMargin + vertMargin / 2
                        }

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scaleFactor
                        scaleY = scaleFactor

                        // Fade the page relative to its size.
                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                    }
                    else -> { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        alpha = 0f
                    }
                }
            }
        }
    }
}