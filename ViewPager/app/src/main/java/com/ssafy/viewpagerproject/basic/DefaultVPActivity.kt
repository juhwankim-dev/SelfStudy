package com.ssafy.viewpagerproject.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.ssafy.viewpagerproject.R
import com.ssafy.viewpagerproject.adapter.DefaultAdapter
import com.ssafy.viewpagerproject.databinding.ActivityDefaultVpactivityBinding

class DefaultVPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDefaultVpactivityBinding
    private var list = mutableListOf(R.drawable.idol1, R.drawable.idol2, R.drawable.idol3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDefaultVpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.defaultViewPagerIdol.adapter = DefaultAdapter(list) // 어댑터 생성
        binding.defaultViewPagerIdol.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
    }
}