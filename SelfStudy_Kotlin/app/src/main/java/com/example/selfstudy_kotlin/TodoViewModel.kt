package com.example.selfstudy_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.selfstudy_kotlin.database.Todo
import com.example.selfstudy_kotlin.repository.TodoRepository

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TodoRepository(application)
    private val items = repository.getAll()

    fun insert(todo: Todo) {
        repository.insert(todo)
    }

    fun delete(todo: Todo){
        repository.delete(todo)
    }

    fun getAll(): LiveData<List<Todo>> {
        return items
    }
}