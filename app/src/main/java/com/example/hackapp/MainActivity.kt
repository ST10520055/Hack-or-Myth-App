package com.example.hackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hackapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // variables
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvDescription: TextView = findViewById(R.id.tvDescription)
        val btnStart: Button = findViewById(R.id.btnStart)


        tvTitle.text = "Hack or Myth?"
        tvDescription.text = "Test your common sense and learn useful, safe real-world shortcuts. Can you spot the viral lies? or are you fooled just like the rest. Take this test to find out"


        btnStart.setOnClickListener {

            val intent = Intent(this,QuizActivity::class.java)
            startActivity(intent)


            finish()
        }
    }
}