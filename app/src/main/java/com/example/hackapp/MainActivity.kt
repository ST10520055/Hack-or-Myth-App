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

        // Initializing the UI components
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val tvDescription: TextView = findViewById(R.id.tvDescription)
        val btnStart: Button = findViewById(R.id.btnStart)

        // Setting the Welcome Text programmatically (optional, can also be done in XML)
        tvTitle.text = "Hack or Myth?"
        tvDescription.text = "Test your common sense and learn useful, safe real-world shortcuts. Can you spot the viral lies?"

        // Set the click listener to move to the Quiz Screen
        btnStart.setOnClickListener {
            // This assumes you have a 'QuizActivity' created
            val intent = Intent(this,QuizActivity::class.java)
            startActivity(intent)

            // Finish this activity so the user can't go back to the welcome screen with the back button
            finish()
        }
    }
}