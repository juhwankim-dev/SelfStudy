package com.example.emptyproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //logAndToast("onCreate")

        button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        var test = HtmlCrawler()
        test.requestPost()
    }

/*    override fun onStart() {
        super.onStart()
        logAndToast("onStart")
    }

    override fun onResume() {
        super.onResume()
        logAndToast("onResume")
    }

    override fun onPause() {
        super.onPause()
        logAndToast("onPause")
    }

    override fun onStop() {
        super.onStop()
        logAndToast("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logAndToast("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logAndToast("onDestroy")
    }

    private fun logAndToast(lifeCycle: String) {
        Log.v("LifeCycle", "${lifeCycle}이 호출되었습니다.")
        Toast.makeText(this, "${lifeCycle}이 호출되었습니다.", Toast.LENGTH_SHORT).show()
    }*/
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