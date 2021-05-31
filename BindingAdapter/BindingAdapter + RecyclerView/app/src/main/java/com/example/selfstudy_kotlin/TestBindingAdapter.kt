package com.example.selfstudy_kotlin

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.selfstudy_kotlin.ui.NoticeAdapter

object TestBindingAdapter {
    @JvmStatic
    @BindingAdapter("items")
    fun setItems(recyclerView: RecyclerView, items: Data?) {
        // recyclerView 어댑터을 생성하지 않았다면 생성해준다.
        if (recyclerView.adapter == null) {
            Log.v("로그", "리사이클러뷰가 없네~")
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = NoticeAdapter()
        }

        // 아이템을 리스트에 넣는다.
        val noticeAdapter: NoticeAdapter = recyclerView.adapter as NoticeAdapter
        Log.v("로그", "items: ${items.toString()}")
        if (items != null){
            noticeAdapter.setList(items.content)
            noticeAdapter.notifyDataSetChanged()
        }
    }
}