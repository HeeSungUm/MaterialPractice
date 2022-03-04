package com.example.materialpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.materialpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val textFieldFragment = TextFieldFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomSheet = ModalBottomSheet()

        changeFragment(textFieldFragment)

        binding.modalButton.setOnClickListener {
            bottomSheet.show(supportFragmentManager, ModalBottomSheet.TAG)
        }
        binding.toStandardButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, StandardBottomSheetActivity::class.java))
        }


    }
    private fun changeFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.container).navigateUp()
}