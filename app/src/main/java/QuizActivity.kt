package com.example.hackapp
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hackapp.R
data class Flashcard(
    val statement: String,
    val isHack: Boolean,
    val explanation: String
)
class QuizActivity : AppCompatActivity() {

//flashcard statements with questions that are either hack or myth
    private val flashcards = listOf(
        Flashcard("Putting a dry towel in the dryer with wet clothes makes them dry faster.", true, "Correct! The dry towel absorbs moisture quickly."),
        Flashcard("Drinking coffee helps you sober up faster after alcohol.", false, "Myth! It just makes you an 'alert' drunk."),
        Flashcard("You can use a banana peel to polish leather shoes.", true, "Hack! The natural oils in the peel work like polish."),
        Flashcard("Adding salt to water makes it boil significantly faster.", false, "Myth! It would take a massive amount of salt to make a difference."),
        Flashcard("Microwaving a wet sponge kills 99% of bacteria.", true, "Hack! Just make sure the sponge is wet so it doesn't catch fire."),
        Flashcard("Shaving hair makes it grow back thicker and darker.", false, "Myth! It only feels coarser because the ends are blunt."),
        Flashcard("Use a staple remover to easily add keys to a keychain.", true, "Hack! It saves your fingernails from getting hurt."),
        Flashcard("Batteries last longer if you store them in the freezer.", false, "Myth! Cold can actually decrease battery life and cause corrosion.")
    )

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        //variables
        val tvStatement = findViewById<TextView>(R.id.tvStatement)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val btnHack = findViewById<Button>(R.id.btnHack)
        val btnMyth = findViewById<Button>(R.id.btnMyth)
        val btnNext = findViewById<Button>(R.id.btnNext)


        displayQuestion(tvStatement, tvFeedback, btnNext)

        btnHack.setOnClickListener {
            processAnswer(true, tvFeedback, btnNext, btnHack, btnMyth)
        }

        btnMyth.setOnClickListener {
            processAnswer(false, tvFeedback, btnNext, btnHack, btnMyth)
        }

        btnNext.setOnClickListener {
            currentIndex++
            if (currentIndex < flashcards.size) {
                displayQuestion(tvStatement, tvFeedback, btnNext)

                // Re-enable buttons for the next question
                btnHack.isEnabled = true
                btnMyth.isEnabled = true

            } else {
                // when all questions are answered move to score screen
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL", flashcards.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun displayQuestion(tvS: TextView, tvF: TextView, btnN: Button) {
        tvS.text = flashcards[currentIndex].statement
        tvF.visibility = View.INVISIBLE
        btnN.visibility = View.GONE
    }

    private fun processAnswer(userGuess: Boolean, tvF: TextView, btnN: Button, bH: Button, bM: Button) {
        val currentCard = flashcards[currentIndex]

        if (userGuess == currentCard.isHack) {
            score++
            tvF.text = "Correct! ${currentCard.explanation}"
            tvF.setTextColor(Color.parseColor("#4CAF50")) // Green
        } else {
            tvF.text = "Wrong! ${currentCard.explanation}"
            tvF.setTextColor(Color.parseColor("#F44336")) // Red
        }

        tvF.visibility = View.VISIBLE
        btnN.visibility = View.VISIBLE

        // after answer, button is disabled so user cant change the answer
        bH.isEnabled = false
        bM.isEnabled = false
    }
}