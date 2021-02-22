package com.example.emptyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        logAndToast("onCreate")
    }

    override fun onStart() {
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
        Log.v("LifeCycle", "Second : ${lifeCycle}이 호출되었습니다.")
        Toast.makeText(this, "Second : ${lifeCycle}이 호출되었습니다.", Toast.LENGTH_SHORT).show()
    }
}