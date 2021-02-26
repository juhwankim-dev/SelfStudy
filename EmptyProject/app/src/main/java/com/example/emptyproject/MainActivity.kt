package com.example.emptyproject

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var numBanner = 3
    private var currentPosition = Int.MAX_VALUE / 2
    private var myHandler = MyHandler()
    private val intervalTime = 1500.toLong()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_total_banner.text = numBanner.toString()
        viewPager_banner.adapter = ViewPagerAdapter(getBannerList())
        viewPager_banner.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager_banner.setCurrentItem(currentPosition, false)

        viewPager_banner.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    textView_current_banner.text = "${(position % 3) + 1}"
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 뷰페이저 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }
    }

    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // 이거 안하면 핸들러가 1개, 2개, 3개 ... n개 만큼 계속 늘어남
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime 만큼 반복해서 핸들러를 실행하게 함
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }

    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                viewPager_banner.setCurrentItem(++currentPosition, true) // 다음 페이지로 이동
                autoScrollStart(intervalTime) // 스크롤을 계속 이어서 한다.
            }
        }
    }

    // 다른 페이지 갔다가 돌아오면 다시 스크롤 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // 다른 페이지로 떠나있는 동안 스크롤이 동작할 필요는 없음. 정지
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    }
}


/*        button.setOnClickListener {
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, AlarmReceiver::class.java)  // 1
            val pendingIntent = PendingIntent.getBroadcast( this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            var from = "2021-02-17 06:38"
            var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
            var datetime = dateFormat.parse(from);
            var calendar = Calendar.getInstance()
            calendar.time = datetime

            alarmManager.set(AlarmManager.RTC, calendar.timeInMillis, pendingIntent)

            Toast.makeText(this, "등록됨", Toast.LENGTH_SHORT).show()
        }*/