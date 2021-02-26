package com.example.emptyproject

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.banner_list_item.view.*

class ViewPagerAdapter(
    bannerList: ArrayList<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = bannerList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.banner.setImageResource(item[position%3])
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.banner_list_item, parent, false)){

        val banner = itemView.imageView_banner!!
    }
}