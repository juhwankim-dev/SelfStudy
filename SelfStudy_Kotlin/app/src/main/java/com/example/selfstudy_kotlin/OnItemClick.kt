package com.example.selfstudy_kotlin

import com.example.selfstudy_kotlin.database.Todo

interface OnItemClick {
    fun deleteTodo(todo: Todo)
}