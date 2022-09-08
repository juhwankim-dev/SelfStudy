package com.example.dialog.custom

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.dialog.databinding.DialogCustomBinding

class CustomDialog(context: Context): Dialog(context) {
    private lateinit var itemClickListener: ItemClickListener
    private lateinit var binding: DialogCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        // 사이즈를 조절하고 싶을 때 사용 (use it when you want to resize dialog)
        // resize(this, 0.8f, 0.4f)

        // 배경을 투명하게 (Make the background transparent)
        // 다이얼로그를 둥글게 표현하기 위해 필요 (Required to round corner)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 다이얼로그 바깥쪽 클릭시 종료되도록 함 (Cancel the dialog when you touch outside)
        setCanceledOnTouchOutside(true)

        // 취소 가능 유무
        setCancelable(true)

        binding.tvCancel.setOnClickListener {
            dismiss() // 다이얼로그 닫기 (Close the dialog)
        }

        binding.tvCall.setOnClickListener {
            // interface를 이용해 다이얼로그를 호출한 곳에 값을 전달함
            // Use interface to pass the value to the activty or fragment
            itemClickListener.onClick("031-467-0000")
            dismiss()
        }
    }

    // 사이즈를 조절하고 싶을 때 사용 (use it when you want to resize dialog)
    private fun resize(dialog: Dialog, width: Float, height: Float){
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        if (Build.VERSION.SDK_INT < 30) {
            val size = Point()
            windowManager.defaultDisplay.getSize(size)

            val x = (size.x * width).toInt()
            val y = (size.y * height).toInt()
            dialog.window?.setLayout(x, y)
        } else {
            val rect = windowManager.currentWindowMetrics.bounds

            val x = (rect.width() * width).toInt()
            val y = (rect.height() * height).toInt()
            dialog.window?.setLayout(x, y)
        }
    }

    interface ItemClickListener {
        fun onClick(message: String)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}