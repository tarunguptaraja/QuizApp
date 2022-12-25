package com.tarunguptaraja.quizapp

object Constants {

    const val username:String="user_name"
    const val totalQuestion:String="total_question"
    const val correctAnswers:String="correcct_answers"


    fun getQuestions():ArrayList<Question>{

        val questionsList=ArrayList<Question>()

        val que1= Question(
            1,
            "What Country does this flag belong to?",
            R.drawable.flag1,
            "Pakistan",
            "Talibaan",
            "India",
            "Afganistan",
            4
        )
        questionsList.add(que1)

        val que2= Question(
            2,
            "What Country does this flag belong to?",
            R.drawable.flag2,
            "Afganistan",
            "Australia",
            "New Zeland",
            "Pakistan",
            2
        )
        questionsList.add(que2)

        val que3= Question(
            3,
            "What Country does this flag belong to?",
            R.drawable.flag3,
            "Afganistan",
            "Bangladesh",
            "Russia",
            "Srilanka",
            2
        )
        questionsList.add(que3)

        val que4= Question(
            4,
            "What Country does this flag belong to?",
            R.drawable.flag4,
            "Asalanka",
            "Pakistan",
            "Afganistan",
            "England",
            4
        )
        questionsList.add(que4)

        val que5= Question(
            5,
            "What Country does this flag belong to?",
            R.drawable.flag5,
            "Afganistan",
            "India",
            "Nepal",
            "Pakistan",
            2
        )
        questionsList.add(que5)

        val que6= Question(
            6,
            "What Country does this flag belong to?",
            R.drawable.flag6,
            "India",
            "Uganda",
            "Ireland",
            "Pakistan",
            3
        )
        questionsList.add(que6)

        val que7= Question(
            7,
            "What Country does this flag belong to?",
            R.drawable.flag7,
            "Australia",
            "New Zeland",
            "Afganistan",
            "USA",
            2
        )
        questionsList.add(que7)

        val que8= Question(
            8,
            "What Country does this flag belong to?",
            R.drawable.flag8,
            "Afganistan",
            "Bangladesh",
            "India",
            "Pakistan",
            4
        )
        questionsList.add(que8)

        val que9= Question(
            9,
            "What Country does this flag belong to?",
            R.drawable.flag9,
            "Afganistan",
            "Bangladesh",
            "South Africa",
            "Pakistan",
            3
        )
        questionsList.add(que9)

        val que10= Question(
            10,
            "What Country does this flag belong to?",
            R.drawable.flag10,
            "India",
            "USA",
            "Sri Lanka",
            "England",
            3
        )
        questionsList.add(que10)

        return questionsList
    }
}