package com.example.presentation.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.example.presentation.config.BaseActivity
import com.example.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

// Activity에는 어노테이션을 붙여주셔야 해요 (hilt)
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) { // 저는 BaseActivity를 만들어 놓고 상속받아 사용해요.
                                                                                 // 이렇게 하면 binding을 일일이 선언할 필요가 없어요.
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이렇게 바로 binding으로 원하는 view에 접근할 수 있어요.
        // findViewById를 사용하지 않으셔도 돼요.
        // binding.textView.text = "테스트"

        // dataBinding에 대한 포스팅: https://todaycode.tistory.com/31

        viewModel.getTempList(1)
        initObserve()
    }

    private fun initObserve() {
        with(viewModel) {
            problem.observe(this@MainActivity) {
                showToastMessage(it.message.toString())
            }
            tempResult.observe(this@MainActivity) {
                // 가져온 it을 화면에 뿌려주는 작업
            }
            readUserList().observe(this@MainActivity) {
                // 가져온 it을 화면에 뿌려주는 작업
            }
        }
    }
}

/*
원래 기본 형태
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
 */