package com.ssafy.viewpagerproject.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.viewpagerproject.adapter.MultipleItemAdapter
import com.ssafy.viewpagerproject.databinding.ActivityMultipleItemVpactivityBinding

// 아이템이 한 화면에 여러 개 보이는 예제입니다.
// ViewPager2 대신 ViewPager를 사용했으니 유의해주세요!
class MultipleItemVPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMultipleItemVpactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleItemVpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.multipleItemViewPagerIcon.adapter = MultipleItemAdapter(this)
    }
}