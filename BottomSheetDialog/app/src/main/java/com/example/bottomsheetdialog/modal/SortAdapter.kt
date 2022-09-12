package com.example.bottomsheetdialog.modal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheetdialog.databinding.ItemModalExample3Binding

class SortAdapter(val list: ArrayList<Sort>) : RecyclerView.Adapter<SortAdapter.ViewHolder>() {
    private lateinit var itemClickListener: ItemClickListener
    private var checkedItem = 0

    inner class ViewHolder(private val binding: ItemModalExample3Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bindInfo(sort: Sort) {
            binding.textView.text = sort.option
            binding.radioButton.isChecked = (checkedItem == layoutPosition)
            binding.imageView.setImageResource(sort.drawable)

            itemView.setOnClickListener {
                checkedItem = layoutPosition
                itemClickListener.onClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemModalExample3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindInfo(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface ItemClickListener {
        fun onClick(position: Int)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}