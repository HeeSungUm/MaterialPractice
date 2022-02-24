package com.example.materialpractice

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.materialpractice.databinding.ActivityStandardBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class StandardBottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStandardBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val standardBottomSheet: BottomSheetBehavior<View> =
            BottomSheetBehavior.from(binding.bottomsheet.bottomsheet)

        standardBottomSheet.peekHeight = 120
        standardBottomSheet.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                var text = ""
                when (newState) {

                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        text = "STATE_COLLAPSED"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        text = "STATE_DRAGGING"
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        text = "STATE_EXPANDED"
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        text = "STATE_HALF_EXPANDED"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        text = "STATE_HIDDEN"
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        text = "STATE_SETTLING"
                    }
                }
                binding.bottomsheet.stateTextView.text = text
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })
        binding.stateHiddenButton.setOnClickListener {
            standardBottomSheet.state = BottomSheetBehavior.STATE_HIDDEN
        }
        binding.stateCollapsedButton.setOnClickListener {
            standardBottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        binding.stateExpandedButton.setOnClickListener {
            standardBottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
        }
        binding.stateSettlingButton.setOnClickListener {
            standardBottomSheet.state = BottomSheetBehavior.STATE_SETTLING
        }

    }
}