package com.tarunguptaraja.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        val button=findViewById<Button>(R.id.button)
        val editText=findViewById<EditText>(R.id.editText)
        button.setOnClickListener{
            val name=editText.text.toString()
            if(name.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent: Intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constants.username,name)
                startActivity(intent)
                finish()
            }

        }
    }
}


