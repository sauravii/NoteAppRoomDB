package com.example.databaseroomnote

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.preference.PreferenceManager

class OnboardActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        setContentView(R.layout.activity_onboard)

        val secondActbutton = findViewById<Button>(R.id.btn_next)
        secondActbutton.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.putBoolean("isFirstOpen", true)
            editor.apply()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}