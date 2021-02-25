package com.example.emptyproject

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs

private const val NUM_PAGES = 2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager_icon.adapter = ScreenSlidePagerAdapter(this)
        viewPager_icon.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        spring_dots_indicator.setViewPager2(viewPager_icon)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> MyFragment1()
                else -> MyFragment2()
            }
        }
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