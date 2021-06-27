package com.example.selfstudy_kotlin

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.selfstudy_kotlin.ui.NoticeAdapter

object TestBindingAdapter {
    private val noticeAdapter: NoticeAdapter = NoticeAdapter()

    @JvmStatic
    @BindingAdapter("items")
    fun setItems(recyclerView: RecyclerView, items: Data?) {
        // recyclerView 어댑터을 생성하지 않았다면 생성해준다.
        if (recyclerView.adapter == null) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = noticeAdapter
            recyclerView.itemAnimator = null
        }

        // 아이템을 리스트에 넣는다.
        if (items != null){
            noticeAdapter.setList(items.content)
            noticeAdapter.notifyItemRangeChanged(0, 10)
        }
    }
}