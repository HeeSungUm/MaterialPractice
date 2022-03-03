package com.example.materialpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.materialpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomSheet = ModalBottomSheet()

        binding.modalButton.setOnClickListener {
            bottomSheet.show(supportFragmentManager, ModalBottomSheet.TAG)
        }
        binding.toStandardButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, StandardBottomSheetActivity::class.java))
        }


    }
}