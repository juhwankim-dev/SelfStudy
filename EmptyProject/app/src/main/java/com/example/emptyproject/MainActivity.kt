package com.example.emptyproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        //tabLayout.tabIconTint = resources.getColorStateList(R.color.tab_icon, null)
    }

    private fun init() {
        val tabIconList = arrayListOf(R.drawable.save, R.drawable.profile)
        //val tabTextList = arrayListOf("HOME", "CHATTING", "NEWS", "SETTING")

        viewPager_profile.adapter = CustomFragmentStateAdapter(this)
        TabLayoutMediator(tabLayout, viewPager_profile) {
                tab, position ->
            tab.setIcon(tabIconList[position])
            //tab.text = tabTextList[position]
        }.attach()
    }

    /* 4개의 프래그먼트를 달아줄 어댑터 */
    inner class CustomFragmentStateAdapter(fragmentActivity: FragmentActivity):
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when(position) {
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