package com.example.selfstudy_kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selfstudy_kotlin.databinding.NoticeItemBinding
import com.example.selfstudy_kotlin.network.NoticeList
import com.example.selfstudy_kotlin.network.Result
import com.example.selfstudy_kotlin.network.ResultList

class NoticeAdapter() : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    private val items = ArrayList<NoticeList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : NoticeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NoticeItemBinding.inflate(layoutInflater)
        return NoticeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(notice: Result) {
        items.clear()
        items.add(NoticeList("짜잔", " ", " "))
        Log.v("3333", notice.resultList[0].SUBJECT!!)
        //items.addAll(notice)
    }

    inner class NoticeViewHolder(private val binding: NoticeItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(notice: NoticeList){
            binding.tvNotice.text = notice.title
        }
    }
}

