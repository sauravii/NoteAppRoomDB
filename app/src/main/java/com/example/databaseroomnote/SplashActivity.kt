package com.example.databaseroomnote

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.example.databaseroomnote.databinding.ActivitySplashBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAction()
    }


    private fun initAction() {
        // onboard cuma sekali
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this@SplashActivity)
        val isFirstOpen = sharedPreferences.getBoolean("isFirstOpen", false)
        GlobalScope.launch {
            delay(3000L)
            if (isFirstOpen) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this@SplashActivity, OnboardActivity::class.java)
                startActivity(intent)
            }
            finish()
        }
    }
}