package com.example.selfstudy_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val todoDao: TodoDao
    private val todoList: LiveData<List<Todo>>

    init {
        var db = AppDatabase.getInstance(application)
        todoDao = db!!.todoDao()
        todoList = db.todoDao().getAll()
    }

    fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    fun getAll(): LiveData<List<Todo>> {
        return todoDao.getAll()
    }
}