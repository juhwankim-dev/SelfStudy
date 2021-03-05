package com.example.selfstudy_kotlin

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object MyBindingAdatper {
    @BindingAdapter("imageUrl")
    fun loadImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }
}