package com.example.bottomsheetdialog.modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomsheetdialog.databinding.ModalExample2Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalExample2 : BottomSheetDialogFragment()  {
    private var binding: ModalExample2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = ModalExample2Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.tvRejectToday.setOnClickListener {
            dismiss()
        }

        binding!!.tvClose.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val TAG = "ModalExample2"
    }
}