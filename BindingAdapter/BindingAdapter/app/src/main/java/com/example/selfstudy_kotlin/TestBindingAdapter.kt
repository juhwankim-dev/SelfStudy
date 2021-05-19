package com.example.selfstudy_kotlin

import android.widget.TextView
import androidx.databinding.BindingAdapter

object TestBindingAdapter {
    @BindingAdapter("text_lulu_lala")
    @JvmStatic
    fun setText(view: TextView, text: String){
        view.text = text + "\n" + text
    }
}