package com.ssafy.viewpagerproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.viewpagerproject.R

class InfiniteAdapter(var list: MutableList<Int>) : RecyclerView.Adapter<InfiniteAdapter.InfiniteViewHolder>() {

    inner class InfiniteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView_banner = itemView.findViewById<ImageView>(R.id.imageView_banner)

        fun onBind(res: Int) {
            imageView_banner.setImageResource(res)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_banner, parent, false)
        return InfiniteViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfiniteViewHolder, position: Int) {
        holder.onBind(list[position % 3]) // position에 실제 배너의 개수를 나눈 나머지 값을 사용한다. (여기서는 3개라 하드코딩으로 3을 넣음)
    }

    override fun getItemCount(): Int = Int.MAX_VALUE // 아이템의 갯수를 임의로 확 늘린다.
}