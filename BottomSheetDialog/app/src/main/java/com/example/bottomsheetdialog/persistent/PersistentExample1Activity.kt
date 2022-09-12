package com.example.bottomsheetdialog.persistent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bottomsheetdialog.R
import com.example.bottomsheetdialog.databinding.ActivityPersistentBinding
import com.example.bottomsheetdialog.databinding.ActivityPersistentExample1Binding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PersistentExample1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPersistentExample1Binding
    lateinit var behavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersistentExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvent()
    }

    private fun initEvent() {
        persistentBottomSheetEvent()
    }

    private fun persistentBottomSheetEvent() {
        behavior = BottomSheetBehavior.from(binding.persistentBottomSheet)
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED-> {

                    }
                    BottomSheetBehavior.STATE_DRAGGING-> {

                    }
                    BottomSheetBehavior.STATE_EXPANDED-> {
                        val intent = Intent(this@PersistentExample1Activity, PlaceInfoActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(intent)
                    }
                    BottomSheetBehavior.STATE_HIDDEN-> {

                    }
                    BottomSheetBehavior.STATE_SETTLING-> {

                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private val TAG = "PersistentActivity"
}