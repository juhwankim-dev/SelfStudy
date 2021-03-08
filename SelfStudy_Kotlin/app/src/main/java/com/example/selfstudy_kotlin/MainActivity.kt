package com.example.selfstudy_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding
import com.example.selfstudy_kotlin.fragments.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private val model: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.todoList.observe(this, Observer{
            binding.textView2.text = it.get(0).content
        })

        binding.btnAdd.setOnClickListener {
            model.insert(Todo(binding.editText.text.toString()))
        }
    }
}
