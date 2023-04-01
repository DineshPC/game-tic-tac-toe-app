package com.example.gametictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //when click on start button goto main page
        newGameBtnOnHomePage.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // when click on option button goto option page
        optionBtnOnHomePage.setOnClickListener{
            val intent = Intent(this, OptionPage::class.java)
            startActivity(intent)
        }
    }
}