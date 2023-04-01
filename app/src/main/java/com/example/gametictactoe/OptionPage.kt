package com.example.gametictactoe

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch

class OptionPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_page)

        val musicSwitch = findViewById<Switch>(R.id.switch1)

        // Get the saved state of the Switch from SharedPreferences
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val musicState = sharedPreferences.getBoolean("music_state", true)

        // Set the Switch to its saved state
        musicSwitch.isChecked = musicState

        // Save the state of the Switch whenever it's changed
        musicSwitch.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPreferences.edit()
            editor.putBoolean("music_state", isChecked)
            editor.apply()
        }
    }
}