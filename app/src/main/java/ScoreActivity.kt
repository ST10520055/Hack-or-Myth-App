package com.example.hackapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.hackapp.QuizActivity
import com.example.hackapp.R

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // 1. Link the UI elements
        val tvFinalScore = findViewById<TextView>(R.id.tvFinalScore)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        // 2. Get the data sent from QuizActivity
        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        // 3. Display the score
        tvFinalScore.text = "Final Score: $score / $total"

        // 4. Set personalised feedback (Requirement 5.1)
        if (score >= total/5 ) {
            tvFeedback.text = "Master Hacker! You're hard to fool."
        } else {
            tvFeedback.text = "Stay Safe Online! Keep practicing."
        }

        // 5. Review Button Logic (Requirement 2.2)
        btnReview.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Quick Review")
            builder.setMessage(
                "• Dry towel in dryer: HACK\n" +
                        "• Coffee sobers you up: MYTH\n" +
                        "• Banana peel shoe polish: HACK\n" +
                        "• Cracking knuckles = Arthritis: MYTH"
            )
            builder.setPositiveButton("Got it!") { dialog, _ -> dialog.dismiss() }
            builder.show()
        }

        // 6. Restart Logic
        btnRestart.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}





