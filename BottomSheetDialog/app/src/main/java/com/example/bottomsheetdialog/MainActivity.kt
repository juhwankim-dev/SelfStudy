package com.example.bottomsheetdialog

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.bottomsheetdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvent()
    }

    private fun initEvent() {
        binding.button.setOnClickListener {
            basicBottomSheet()
        }
        binding.button2.setOnClickListener {
            bottomSheetWithRoundCorner()
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this, PersistentBottomSheetActivity::class.java))
        }
        binding.button4.setOnClickListener {

        }
        binding.button5.setOnClickListener {

        }
        binding.textView.apply {
            paintFlags = Paint.UNDERLINE_TEXT_FLAG
            setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://todaycode.tistory.com/184")))
            }
        }
    }

    private fun basicBottomSheet() {
        val bottomSheetDialog = BasicBottomSheet()
        bottomSheetDialog.show(supportFragmentManager, BasicBottomSheet.TAG)
    }

    private fun bottomSheetWithRoundCorner() {
        val bottomSheetDialog = BasicBottomSheet()
        bottomSheetDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialogTheme)
        bottomSheetDialog.show(supportFragmentManager, BasicBottomSheet.TAG)
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    private val TAG = "MainActivity"
}