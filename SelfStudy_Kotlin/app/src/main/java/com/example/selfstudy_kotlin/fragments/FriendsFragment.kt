package com.example.selfstudy_kotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.selfstudy_kotlin.R
import com.example.selfstudy_kotlin.databinding.FragmentFriendsBinding
import com.example.selfstudy_kotlin.databinding.FragmentHomeBinding

class FriendsFragment : Fragment() {

    private var mBinding : FragmentFriendsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFriendsBinding.inflate(inflater, container, false)
        mBinding = binding

        // Inflate the layout for this fragment
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}