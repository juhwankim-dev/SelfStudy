package com.example.dialog

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog.custom.CustomDialog
import com.example.dialog.databinding.ActivityMainBinding
import com.example.dialog.databinding.DialogCustom2Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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
            materialBasicDialog()
        }
        binding.button2.setOnClickListener {
            materialNegativePositiveDialog()
        }
        binding.button3.setOnClickListener {
            materialNeutralDialog()
        }
        binding.button4.setOnClickListener {
            materialListDialog()
        }
        binding.button5.setOnClickListener {
            materialRadioDialog()
        }
        binding.button6.setOnClickListener {
            materialCheckBoxDialog()
        }
        binding.button7.setOnClickListener {
            customDialog()
        }
        binding.button8.setOnClickListener {
            customDialog2()
        }
        binding.textView.apply {
            paintFlags = Paint.UNDERLINE_TEXT_FLAG
            setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://todaycode.tistory.com/184")))
            }
        }
    }

    // only text
    private fun materialBasicDialog() {
        MaterialAlertDialogBuilder(this)
            .setMessage("Hello, I am a basic dialog")
            .show()
    }

    // with negative & positive button
    private fun materialNegativePositiveDialog() {
        MaterialAlertDialogBuilder(this)
            .setMessage("Hello, I have negative & positive button.")
            .setNegativeButton("cancel") { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton("confirm") { dialog, which ->
                // Respond to positive button press
            }
            .show()
    }

    // added neutral button
    private fun materialNeutralDialog() {
        MaterialAlertDialogBuilder(this)
            .setMessage("Hello, I have one more neutral button added")
            .setNeutralButton("cancel") { dialog, which ->
                // Respond to neutral button press
            }
            .setNegativeButton("decline") { dialog, which ->
                // Respond to negative button press
            }
            .setPositiveButton("accept") { dialog, which ->
                // Respond to positive button press
            }
            .show()
    }

    // with list
    private fun materialListDialog() {
        val items = arrayOf("banana", "apple", "watermelon")

        MaterialAlertDialogBuilder(this)
            .setTitle("Choose what you like")
            //.setMessage("DO NOT SET MESSAGE WHEN YOU USE LIST")
            .setItems(items) { dialog, which ->
                showToastMessage("Oh, you like ${items[which]}!")
            }
            .show()
    }

    // with radiobutton
    private fun materialRadioDialog() {
        val singleItems = arrayOf("banana", "apple", "watermelon")
        var checkedItem = 0

        MaterialAlertDialogBuilder(this)
            .setTitle("Choose what you like")
            .setNeutralButton("cancel") { dialog, which ->
                // Respond to neutral button press
            }
            .setPositiveButton("ok") { dialog, which ->
                showToastMessage("Oh, you like ${singleItems[checkedItem]}!")
            }
            // Single-choice items (initialized with checked item)
            .setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
                checkedItem = which
            }
            .show()
    }

    // with checkbox
    private fun materialCheckBoxDialog() {
        val multiItems = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItems = booleanArrayOf(true, false, false, false)

        MaterialAlertDialogBuilder(this)
            .setTitle("Choose what you like")
            .setNeutralButton("cancel") { dialog, which ->
                // Respond to neutral button press
            }
            .setPositiveButton("ok") { dialog, which ->
                val checkCnt = checkedItems.count { it }
                showToastMessage("you choose $checkCnt items")
            }
            // Single-choice items (initialized with checked item)
            .setMultiChoiceItems(multiItems, checkedItems) { dialog, which, checked ->
                checkedItems[which] = checked
            }
            .show()
    }

    // custom dialog
    // 따로 클래스 파일 생성 + 코드에서 속성 직접 설정 (make another dialog class file + set properties in code)
    private fun customDialog() {
        val dialog = CustomDialog(this)

        dialog.setItemClickListener(object : CustomDialog.ItemClickListener{
            override fun onClick(tel: String) {
                showToastMessage("${tel}로 전화를 걸겠습니다.")
            }
        })

        dialog.show()
    }

    // custom dialog 2
    // 클래스 파일 안 만듦 + themes.xml에서 속성 설정 (not make class file + set properties in themes.xml)
    private fun customDialog2() {
        val binding = DialogCustom2Binding.inflate(LayoutInflater.from(this))
        val dialog = MaterialAlertDialogBuilder(this, R.style.CustomDialog2Theme)
            .setView(binding.root)
            .create()

        binding.btnConfirm.setOnClickListener {
            showToastMessage("확인을 눌렀습니다.")
        }

        dialog.show()
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}