package com.example.mathgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.text.toInt
import kotlin.text.toInt as toInt1

// It also made everything easier by making every activity be able to edit these variables
// This varabile keeps track of how many questions to ask
var questionCount = "0"
// This figures out which operator to select
var operatorNum = 0
// This figures out the difficulty
var difficultyNum = 0
var runner = false
class MainActivity : AppCompatActivity() {
    /**
     * basic on create
     * makes the app appear
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Problem", runner.toString())
        if (runner){
            textView()
        }
        runner = true
        questionCount = "0"
            var questionCountView = findViewById<TextView>(R.id.howmanyquestions)
            questionCountView.setText(questionCount)

        }
    fun textView() {
        var questionNumber = questionCount.toInt()
        var logCheck = (correct / questionNumber.toDouble())
        Log.i("Problem",logCheck.toString())
        if ((correct / questionNumber) * 100 > 80) {
            if (operatorNum == 1) {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.GRAY)
                endStateView.setText("You got " + correct.toString() + " out of " + questionCount + " correct in subtraction. Good Work")
            } else if (operatorNum == 2) {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.GRAY)
                endStateView.setText("You got " + correct.toString() + " out of " + questionCount + " correct in division. Good Work")
            } else if (operatorNum == 3) {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.GRAY)
                endStateView.setText("You got " + correct.toString() + " out of " + questionCount + " correct in multiplication. Good Work")
            } else {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.GRAY)
                endStateView.setText("You got " + correct.toString() + " out of " + questionCount + " correct in addition. Good Work")
            }
        } else {
            if (operatorNum == 1) {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.RED)
                endStateView.setText("You got " + correct.toString() + " out of  " + questionCount + " correct in subtraction. You need to practice more!")
            } else if (operatorNum == 2) {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.RED)
                endStateView.setText("You got " + correct.toString() + " out of " + questionCount + " correct in division. You need to practice more!")
            } else if (operatorNum == 3) {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.RED)
                endStateView.setText("You got " + correct.toString() + " out of " + questionCount + " correct in multiplication. You need to practice more!")
            } else {
                var endStateView = findViewById<TextView>(R.id.endState)
                endStateView.setTextColor(Color.RED)
                endStateView.setText("You got " + correct.toString() + " out of " + questionCount + " correct in addition. You need to practice more!")
            }
        }
    }

        /**
         * Button that adds to the question tally
         */
        fun plus(view: View) {
            var num = questionCount.toInt()
            num++
            questionCount = num.toString()
            var questionCountView = findViewById<TextView>(R.id.howmanyquestions)
            questionCountView.setText(questionCount)
            Log.i("Button", "plus was pressed")
        }

        /**
         * button that swtiches to the next activity if question isnt zero and a operator and difficulty have been selected
         */
        fun start(view: View) {
            correct = 0
            if (operatorNum != 0 && difficultyNum != 0 && questionCount.toInt() > 0) {
                var i = Intent(this@MainActivity, MathScreen::class.java)
                startActivity(i)
            }
            Log.i("Button", "start was pressed")

        }

        /**
         * takes away a question tally if its above zero
         */
        fun minus(view: View) {
            var num = questionCount.toInt()
            num--
            var questionCountView = findViewById<TextView>(R.id.howmanyquestions)
            // checks if its above zero
            if (num < 0) {
                questionCountView.setText(questionCount)
            } else {
                questionCount = num.toString()
                questionCountView.setText(questionCount)
            }
            Log.i("Button", "minus was pressed")
        }

        // All these buttons are the same they just edit the operatorNum or difficultyNum slightly differently
        fun sub(view: View) {
            operatorNum = 1
            Log.i("Button", "sub: was pressed")
        }

        fun divide(view: View) {
            operatorNum = 2
            Log.i("Button", "divide was pressed")
        }

        fun multi(view: View) {
            operatorNum = 3
            Log.i("Button", "multiply was pressed")
        }

        fun add(view: View) {
            operatorNum = 4
            Log.i("Button", "addition was pressed")
        }

        fun hard(view: View) {
            difficultyNum = 3
            Log.i("Button", "hard mode was pressed")
        }

        fun mid(view: View) {
            difficultyNum = 2
            Log.i("Button", "medium mode was pressed")
        }

        fun easy(view: View) {
            difficultyNum = 1
            Log.i("Button", "easy mode was pressed")
        }


    }