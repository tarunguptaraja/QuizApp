package com.tarunguptaraja.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val userName=intent.getStringExtra(Constants.username)
        val total=intent.getStringExtra(Constants.totalQuestion)
        val correct = intent.getStringExtra(Constants.correctAnswers)

        val name=findViewById<TextView>(R.id.username)
        name.text = userName

        val score = findViewById<TextView>(R.id.score)
        score.text = "Your score is $correct out of  $total ."

        val button = findViewById<Button>(R.id.finish)
        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}