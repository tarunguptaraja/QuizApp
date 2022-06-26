package com.tarunguptaraja.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity() {

    private var mCurrPosition:Int=1
    private var mQuestionsList: ArrayList<Question>?= null
    private var mselectedOptPos: Int= 0
    private var mCorrectAnswer:Int=0
    private var mUserNamme:String?=null
    val optionList =ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        mUserNamme=intent.getStringExtra(Constants.username)

        mQuestionsList = Constants.getQuestions()

        val option1 = findViewById<TextView>(R.id.option1)
        val option2 = findViewById<TextView>(R.id.option2)
        val option3 = findViewById<TextView>(R.id.option3)
        val option4 = findViewById<TextView>(R.id.option4)

        val button = findViewById<Button>(R.id.button)

        setQuestion()

        option1.setOnClickListener{
            selectedOptionView(option1,0)
        }
        option2.setOnClickListener {
            selectedOptionView(option2,1)
        }
        option3.setOnClickListener {
            selectedOptionView(option3,2)
        }
        option4.setOnClickListener{
            selectedOptionView(option4,4)
        }

        button.setOnClickListener{
            if(mselectedOptPos==0){
                mCurrPosition++

                when{
                    mCurrPosition <= mQuestionsList!!.size->{
                        setQuestion()

                    }else->{
//                        Toast.makeText(this, "You have successfully completed the Quiz!", Toast.LENGTH_SHORT).show()
                        val intent: Intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.username,mUserNamme)
                        intent.putExtra(Constants.correctAnswers,mCorrectAnswer)
//                        intent.putExtra(Constants.totalQuestion,mQuestionsList!!.size)
                        startActivity(intent)
                    }
                }
            }else{
                val question = mQuestionsList?.get(mCurrPosition-1)
                if(question!!.correct!=mselectedOptPos+1){
                    answerView(mselectedOptPos,R.drawable.wrong)
                }else{
                    mCorrectAnswer++
                }
                answerView(question.correct-1,R.drawable.right)

                if(mCurrPosition==mQuestionsList!!.size){
                    button.setText("FINISH")
                }else{
                    button.setText("GO TO NEXT QUESTION")
                }
                mselectedOptPos=0
            }
        }


    }
    private fun setQuestion(){
        val button = findViewById<Button>(R.id.button)
        defaultOptionView()

        if(mCurrPosition==mQuestionsList!!.size){
            button.setText("FINISH")
        }else{
            button.setText("SUBMIT")
        }

        val question = mQuestionsList!!.get(mCurrPosition-1)
        val position = findViewById<TextView>(R.id.position)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val questions = findViewById<TextView>(R.id.question)
        val image = findViewById<ImageView>(R.id.image)
        val option1 = findViewById<TextView>(R.id.option1)
        val option2 = findViewById<TextView>(R.id.option2)
        val option3 = findViewById<TextView>(R.id.option3)
        val option4 = findViewById<TextView>(R.id.option4)

        progressBar.progress=mCurrPosition
        position.text="$mCurrPosition"+"/"+progressBar.max
        questions.text=question!!.question
        image.setImageResource(question.image)
        option1.text=question.option1
        option2.text=question.option2
        option3.text=question.option3
        option4.text=question.option4
    }

    private fun defaultOptionView(){
        val option1 = findViewById<TextView>(R.id.option1)
        val option2 = findViewById<TextView>(R.id.option2)
        val option3 = findViewById<TextView>(R.id.option3)
        val option4 = findViewById<TextView>(R.id.option4)

        optionList.add(0,option1)
        optionList.add(1,option2)
        optionList.add(2,option3)
        optionList.add(3,option4)

        for(option in optionList){
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.optionbg)
        }
    }

//    fun onClick(v: View?) {
//        val option1 = findViewById<TextView>(R.id.option1)
//        val option2 = findViewById<TextView>(R.id.option2)
//        val option3 = findViewById<TextView>(R.id.option3)
//        val option4 = findViewById<TextView>(R.id.option4)
//        when(v?:id){
//            R.id.option1->{
//                selectedOptionView(option1,1)
//            }
//            R.id.option2->{
//                selectedOptionView(option1,2)
//            }
//            R.id.option3->{
//                selectedOptionView(option1,3)
//            }
//            R.id.option4->{
//                selectedOptionView(option1,4)
//            }
//        }



//    }

    private fun answerView(answer:Int, drawableView:Int){
        val option1 = findViewById<TextView>(R.id.option1)
        val option2 = findViewById<TextView>(R.id.option2)
        val option3 = findViewById<TextView>(R.id.option3)
        val option4 = findViewById<TextView>(R.id.option4)

        when(answer){
            0->{
                option1.background=ContextCompat.getDrawable(this,drawableView)
            }
            1->{
                option2.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                option3.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                option4.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun selectedOptionView(option: TextView,selectedOption:Int){
        defaultOptionView()
        mselectedOptPos = selectedOption
        option.setTypeface(option.typeface,Typeface.BOLD)
        option.background=ContextCompat.getDrawable(this,R.drawable.sel_opt)
    }


}