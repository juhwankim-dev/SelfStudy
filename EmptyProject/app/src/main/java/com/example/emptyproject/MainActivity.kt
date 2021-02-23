package com.example.emptyproject

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* 여백, 너비에 대한 정의 */
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pagerWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        viewPager_idol.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        viewPager_idol.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
        viewPager_idol.adapter = ViewPagerAdapter(getIdolList())
        viewPager_idol.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun getIdolList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4)
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