package com.example.app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.databinding.ActivityThirdBinding
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private val sharedPreferences: SharedPreferences by lazy{
        getSharedPreferences("Appdata", Context.MODE_PRIVATE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowBack.setOnClickListener {
            finish()
        }
        binding.switcher.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferences.edit().putBoolean("theme", true).apply()
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferences.edit().putBoolean("theme", false).apply()

            }
        }
       binding.switcher.isChecked = sharedPreferences.getBoolean("theme", false)
    }

}

//buttonView,
////                                                      isChecked ->
//            if(isChecked)
//            {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                switcher.isChecked
//
//            }
//