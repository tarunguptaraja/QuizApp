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
        val total=10
        var correct: Int? = intent.getStringExtra(Constants.correctAnswers)?.toInt()
        if(correct==null) correct=6
        val name=findViewById<TextView>(R.id.username)
        name.setText(userName)

        val score = findViewById<TextView>(R.id.score)
        score.setText("Your score is $correct out of  $total .")

        val button = findViewById<Button>(R.id.finish)
        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}