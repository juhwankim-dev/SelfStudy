package com.example.bottomsheetdialog

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.bottomsheetdialog.modal.ModalBottomSheet
import com.example.bottomsheetdialog.databinding.ActivityMainBinding
import com.example.bottomsheetdialog.modal.ModalExample1
import com.example.bottomsheetdialog.modal.ModalExample2
import com.example.bottomsheetdialog.persistent.PersistentActivity

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
            modalBottomSheet()
        }
        binding.button2.setOnClickListener {
            modalWithRoundCorner()
        }
        binding.button3.setOnClickListener {
            //startActivity(Intent(this, PersistentActivity::class.java))
            modalExample1()
        }
        binding.button4.setOnClickListener {
            modalExample2()
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

    private fun modalBottomSheet() {
        val modal = ModalBottomSheet()
        modal.show(supportFragmentManager, ModalBottomSheet.TAG)
    }

    private fun modalWithRoundCorner() {
        val modal = ModalBottomSheet()
        modal.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialogTheme)
        modal.show(supportFragmentManager, ModalBottomSheet.TAG)
    }

    private fun modalExample1() {
        val modal = ModalExample1()
        modal.show(supportFragmentManager, ModalExample1.TAG)
    }

    private fun modalExample2() {
        val modal = ModalExample2()
        modal.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialogTheme)
        modal.show(supportFragmentManager, ModalExample2.TAG)
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    private val TAG = "MainActivity"
}