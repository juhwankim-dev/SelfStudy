package com.example.selfstudy_kotlin.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.selfstudy_kotlin.R
import com.example.selfstudy_kotlin.database.Todo
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding
import com.example.selfstudy_kotlin.databinding.TodoItemBinding

class TodoAdapter() : RecyclerView.Adapter<TodoViewHolder>() {

    private val items = ArrayList<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TodoViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater)
        return TodoViewHolder(binding)
    } // 뷰홀더 생성

    override fun getItemCount(): Int { // 아이템의 총 갯수 반환
        return items.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) { // 생선된 뷰홀더에 데이터 삽입
        holder.bind(items[position])
    }

    fun setList(todo: List<Todo>) {
        items.clear()
        items.addAll(todo)
    }
}

class TodoViewHolder(private val binding: TodoItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(item: Todo){
        binding.tvTodo.text = item.content
        binding.ivIcon.setOnClickListener {
            Log.v("클릭됨", item.content + "클릭됨")
        }
    }
}