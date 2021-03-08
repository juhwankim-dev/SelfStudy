package com.example.selfstudy_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class TodoViewModel(application: Application) : AndroidViewModel(application) {
/*    private val todoDao: TodoDao
    val todoList: LiveData<List<Todo>>

    init {
        var db = Room.databaseBuilder(application, AppDatabase::class.java, "database-name").allowMainThreadQueries().build()
        todoDao = db.todoDao()
        todoList = db.todoDao().getAll()
    }*/
    private val todoDao by lazy {
    var db = Room.databaseBuilder(application, AppDatabase::class.java, "database-name").allowMainThreadQueries().build()
    db.todoDao()
}

    val todoList: LiveData<List<Todo>> by lazy {
        todoDao.getAll()
    }

    fun insert(todo: Todo){
        todoDao.insert(todo)
    }
}