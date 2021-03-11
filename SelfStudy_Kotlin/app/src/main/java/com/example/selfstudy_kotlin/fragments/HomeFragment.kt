package com.example.selfstudy_kotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfstudy_kotlin.OnItemClick
import com.example.selfstudy_kotlin.R
import com.example.selfstudy_kotlin.TodoAdapter
import com.example.selfstudy_kotlin.TodoViewModel
import com.example.selfstudy_kotlin.database.Todo
import com.example.selfstudy_kotlin.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment(), OnItemClick {

    private var binding : FragmentHomeBinding? = null
    private val model: TodoViewModel by viewModels()
    private lateinit var adapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        model.getAll().observe(viewLifecycleOwner, Observer{
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })

        binding!!.btnAdd.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                model.insert(Todo(binding!!.editText.text.toString()))
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun initRecyclerView(){
        binding!!.recyclerViewTodo.layoutManager = LinearLayoutManager(context)
        adapter = TodoAdapter(this)
        binding!!.recyclerViewTodo.adapter = adapter
    }

    override fun deleteTodo(todo: Todo) {
        lifecycleScope.launch(Dispatchers.IO){
            model.delete(todo)
        }
    }
}