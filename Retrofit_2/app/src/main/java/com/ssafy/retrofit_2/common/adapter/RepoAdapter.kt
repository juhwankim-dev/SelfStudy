package com.ssafy.retrofit_2.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.retrofit_2.common.dto.Item
import com.ssafy.retrofit_2.databinding.ListItemRepoBinding

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    var repoList = mutableListOf<Item>()

    inner class RepoViewHolder(private val binding: ListItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindInfo(item: Item) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        var listItemBinding = ListItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bindInfo(repoList[position])
    }

    override fun getItemCount(): Int = repoList.size

    fun loadNextPage (list: List<Item>) {
        repoList.clear()
        repoList.addAll(list)
        notifyDataSetChanged()
    }
}