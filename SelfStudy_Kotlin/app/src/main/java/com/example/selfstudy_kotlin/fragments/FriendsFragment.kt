package com.example.selfstudy_kotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfstudy_kotlin.*
import com.example.selfstudy_kotlin.databinding.FragmentFriendsBinding

class FriendsFragment : Fragment() {

    private var binding : FragmentFriendsBinding? = null
    private val model: NoticeViewModel by viewModels()
    private lateinit var adapter: NoticeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFriendsBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        model.requestPost()

        model.getAll().observe(viewLifecycleOwner, Observer{
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun initRecyclerView(){
        binding!!.recyclerViewNotice.layoutManager = LinearLayoutManager(context)
        adapter = NoticeAdapter()
        binding!!.recyclerViewNotice.adapter = adapter
    }
}