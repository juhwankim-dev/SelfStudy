package com.example.bottomsheetdialog.modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheetdialog.R
import com.example.bottomsheetdialog.databinding.ModalExample3Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// 선택한 옵션 값을 유지하기 위해 싱글톤으로 만듦
object ModalExample3 : BottomSheetDialogFragment() {
    lateinit var binding: ModalExample3Binding
    private val list = arrayListOf (
        Sort(R.drawable.ic_chart, "판매 인기 순"),
        Sort(R.drawable.ic_down, "낮은 가격 순"),
        Sort(R.drawable.ic_up, "높은 가격 순"),
        Sort(R.drawable.ic_star, "상품평 많은 순"),
        Sort(R.drawable.ic_cumulative_sales, "누적 판매 순")
    )
    private val sortAdapter = SortAdapter(list)
    const val TAG = "ModalExample3"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = ModalExample3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSort.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sortAdapter

            sortAdapter.setItemClickListener(object : SortAdapter.ItemClickListener{
                override fun onClick(position: Int) {
                    // 선택한 옵션(position)으로 원하는 작업
                    dismiss()
                }
            })
        }

        binding.ivClose.setOnClickListener {
            dismiss()
        }
    }
}