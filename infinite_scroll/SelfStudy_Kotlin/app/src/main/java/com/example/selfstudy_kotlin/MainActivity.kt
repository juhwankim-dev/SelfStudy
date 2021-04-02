package com.example.selfstudy_kotlin

import android.R
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.selfstudy_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainViewModel
    private lateinit var noticeAdapter: NoticeAdapter
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model = ViewModelProvider(this).get(MainViewModel::class.java)

        model.loadBaeminNotice(page)

        binding.rvBaeminNotice.apply {
            binding.rvBaeminNotice.layoutManager = LinearLayoutManager(context)
            noticeAdapter = NoticeAdapter()
            binding.rvBaeminNotice.adapter = noticeAdapter
        }

        model.getAll().observe(this, Observer{
            noticeAdapter.setList(it.content)
            noticeAdapter.notifyItemRangeInserted((page - 1) * 10, 10)
        })

        binding.rvBaeminNotice.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter!!.itemCount-1

                if (!binding.rvBaeminNotice.canScrollVertically(1) && lastVisibleItemPosition == itemTotalCount) {
                    noticeAdapter.deleteLoading()
                    model.loadBaeminNotice(++page)
                }
            }
        })
    }
}
