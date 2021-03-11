package com.example.selfstudy_kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selfstudy_kotlin.database.Todo
import com.example.selfstudy_kotlin.databinding.TodoItemBinding

class TodoAdapter(listener: OnItemClick) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private val mCallback = listener
    private val items = ArrayList<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(layoutInflater)
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setList(todo: List<Todo>) {
        items.clear()
        items.addAll(todo)
    }

    inner class TodoViewHolder(private val binding: TodoItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item: Todo){
            binding.tvTodo.text = item.content
            binding.ivIcon.setOnClickListener {
                mCallback.deleteTodo(item)
            }
        }
    }
}

