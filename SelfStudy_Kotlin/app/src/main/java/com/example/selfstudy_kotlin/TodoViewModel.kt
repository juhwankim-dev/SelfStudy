package com.example.selfstudy_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.selfstudy_kotlin.database.AppDatabase
import com.example.selfstudy_kotlin.database.Todo
import com.example.selfstudy_kotlin.database.TodoDao

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

    fun delete(todo: Todo){
        todoDao.delete(todo)
    }

    fun getAll(): LiveData<List<Todo>> {
        return todoDao.getAll()
    }
}