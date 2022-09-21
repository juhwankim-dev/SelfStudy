package com.example.bottomsheetdialog.modal

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomsheetdialog.databinding.ModalExample1Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalExample1 : BottomSheetDialogFragment()  {
    lateinit var binding: ModalExample1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = ModalExample1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvReject.apply {
            paintFlags = Paint.UNDERLINE_TEXT_FLAG // 밑줄
            setOnClickListener {
                dismiss()
            }
        }

        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.btnEventOn.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val TAG = "ModalExample1"
    }
}