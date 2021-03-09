package com.example.selfstudy_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding
import com.example.selfstudy_kotlin.fragments.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model.getAll().observe(this, Observer{
            if(it.isNotEmpty()){
                var str = "메모: "
                val iterator = it.iterator()
                while(iterator.hasNext()){
                    str += iterator.next().content
                }

                binding.textView2.text = str
            }
        })

        binding.btnAdd.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                model.insert(Todo(binding.editText.text.toString()))
            }
        }
    }
}
