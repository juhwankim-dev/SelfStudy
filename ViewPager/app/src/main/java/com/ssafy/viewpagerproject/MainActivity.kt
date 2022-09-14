package com.ssafy.viewpagerproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssafy.viewpagerproject.advanced.*
import com.ssafy.viewpagerproject.basic.*
import com.ssafy.viewpagerproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvent()
    }

    fun initEvent() {
        binding.button.setOnClickListener {
            startActivity(Intent(this, DefaultVPActivity::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this, AnimationVPActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this, MarginVPActivity::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this, MarginVP2Activity::class.java))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this, MultipleItemVPActivity::class.java))
        }
        binding.button6.setOnClickListener {
            startActivity(Intent(this, VPWithIndicatorActivity::class.java))
        }
        binding.button7.setOnClickListener {
            startActivity(Intent(this, VPWithFragmentActivity::class.java))
        }
        binding.button8.setOnClickListener {
            startActivity(Intent(this, VPWithTabLayoutActivity::class.java))
        }
        binding.button9.setOnClickListener {
            startActivity(Intent(this, BannerVPActivity::class.java))
        }
        binding.button10.setOnClickListener {
            startActivity(Intent(this, InfiniteVPActivity::class.java))
        }
        binding.button11.setOnClickListener {
            startActivity(Intent(this, AutoScrollVPActivity::class.java))
        }
    }
}