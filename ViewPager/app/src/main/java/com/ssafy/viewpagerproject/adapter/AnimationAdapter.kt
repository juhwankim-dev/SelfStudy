package com.ssafy.viewpagerproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.viewpagerproject.R

class AnimationAdapter(var list: MutableList<Int>) : RecyclerView.Adapter<AnimationAdapter.AnimationViewHolder>() {

    inner class AnimationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView_icon = itemView.findViewById<ImageView>(R.id.imageView_icon)

        fun onBind(res: Int) {
            imageView_icon.setImageResource(res)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimationViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_icon, parent, false)
        return AnimationViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}