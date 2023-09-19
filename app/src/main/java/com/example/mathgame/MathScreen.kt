package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.log
import kotlin.math.round
import kotlin.random.Random
//These variables are mainly used in this file but correct and counter are used in other ones
// counts how many times math ran
var counter = 0
// The first number in the question text view
var num1 = 0
// the second number in the question text view
var num2 = 0
// counts up how many correct answers there are
var correct = 0
// makes sure its a valid input
var mathPassed = false
class MathScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mathscreen)
        if (operatorNum == 1){
            if (difficultyNum == 1){
                num1 = Random.nextInt(0,10)
                num2 = Random.nextInt(0,10)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "-" + " " + num2.toString())
            }
            else if (difficultyNum == 2){
                num1 = Random.nextInt(0,25)
                num2 = Random.nextInt(0,25)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "-" + " " + num2.toString())
            }else if (difficultyNum == 3){
                num1 = Random.nextInt(0,50)
                num2 = Random.nextInt(0,50)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "-" + " " + num2.toString())
            }
        }
        else if (operatorNum == 2){
            val toast = Toast.makeText(this,"Please round to nearest hundredth",Toast.LENGTH_SHORT)
            toast.show()
            if (difficultyNum == 1){
                num1 = Random.nextInt(0,10)
                num2 = Random.nextInt(1,10)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "/" + " " + num2.toString())
            }
            else if (difficultyNum == 2){
                num1 = Random.nextInt(0,25)
                num2 = Random.nextInt(1,25)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "/" + " " + num2.toString())
            }else if (difficultyNum == 3){
                num1 = Random.nextInt(0,50)
                num2 = Random.nextInt(1,50)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "/" + " " + num2.toString())
            }
        }
        else if (operatorNum == 3){
            if (difficultyNum == 1){
                num1 = Random.nextInt(0,10)
                num2 = Random.nextInt(0,10)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "x" + " " + num2.toString())
            }
            else if (difficultyNum == 2){
                num1 = Random.nextInt(0,25)
                num2 = Random.nextInt(0,25)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "x" + " " + num2.toString())
            }else if (difficultyNum == 3){
                num1 = Random.nextInt(0,50)
                num2 = Random.nextInt(0,50)
                var question = findViewById<TextView>(R.id.question)
                question.setText(num1.toString() + " " + "x" + " " + num2.toString())
            }
        }else{
            if (difficultyNum == 1){
            num1 = Random.nextInt(0,10)
            num2 = Random.nextInt(0,10)
            var question = findViewById<TextView>(R.id.question)
            question.setText(num1.toString() + " " + "+" + " " + num2.toString())
        }
        else if (difficultyNum == 2){
            num1 = Random.nextInt(0,25)
            num2 = Random.nextInt(0,25)
            var question = findViewById<TextView>(R.id.question)
            question.setText(num1.toString() + " " + "+" + " " + num2.toString())
        }else if (difficultyNum == 3){
            num1 = Random.nextInt(0,50)
            num2 = Random.nextInt(0,50)
            var question = findViewById<TextView>(R.id.question)
            question.setText(num1.toString() + " " + "+" + " " + num2.toString())
        }
        }
    }
    // 1 is sub 2 is divide 3 is multi 4 is add
    /**
     * math doesnt return anything it just runs any time after the submit button is pushed
     * it checks what the operator is based on what ever number is provided
     * it then does the function itself with the two randomly selected numbers
     * it then takes the user input and checks if its right
     * if its right the correct Int gets added by one if its wrong nothing happens
     */
    fun math(){
        // Every single one of these works the same except for the division son one which as said above is 2
        // Division rounds the number so the user doesn't have to enter such a long decimal to get a right answer
        // It also has to change the number from a Int to a double so you can do actual dividing
        if (operatorNum == 1){
            // operation
            val answer = num1 - num2
            // gets user answer
            var userAnswer = findViewById<EditText>(R.id.answer)
            // make sure its actually a number
            var stringCheck = checker(userAnswer.getText().toString())
            // if so it runs
            // if not the program ends
            if (stringCheck){
                // checks if anwser is right
                if (userAnswer.getText().toString().toInt() == answer){
                    // if so correct goes up by one
                    // counter goes up by one
                    // and math passed becomes true
                    correct++
                    counter++
                    mathPassed = true
                    // clears the text box
                    userAnswer.getText().clear()
                    Log.i("TEST", "math: correct")
                }
                else{
                    counter++
                    mathPassed = true
                    userAnswer.getText().clear()
                    Log.i("TEST","math: incorrect")
                }
            }
        }
        else if (operatorNum == 2){
            // makes the nums double
            val doubleNum1 = num1.toDouble()
            val doubleNum2 = num2.toDouble()
            val answer = (doubleNum1 / doubleNum2)
            // this rounds the actual number
            var answerRounded = round(answer * 100) / 100
            // everything else is the same as the one above
            var userAnswer = findViewById<EditText>(R.id.answer)
            var stringCheck = checker(userAnswer.getText().toString())
            if (stringCheck){
                if (userAnswer.getText().toString().toDouble() == answerRounded){
                    correct++
                    counter++
                    mathPassed = true
                    userAnswer.getText().clear()
                    Log.i("TEST", "math: correct")
                }
                else{
                    counter++
                    mathPassed = true
                    userAnswer.getText().clear()
                    Log.i("TEST","math: incorrect")
                }
            }
        }
        else if (operatorNum == 3){
            val answer = num1 * num2
            var userAnswer = findViewById<EditText>(R.id.answer)
            var stringCheck = checker(userAnswer.getText().toString())
            if (stringCheck){
                if (userAnswer.getText().toString().toInt() == answer){
                    correct++
                    counter++
                    mathPassed = true
                    userAnswer.getText().clear()
                    Log.i("TEST", "math: correct")
                }
                else{
                    counter++
                    mathPassed = true
                    userAnswer.getText().clear()
                    Log.i("TEST","math: incorrect")
                }
            }
        }
        else{
            val answer = num1 + num2
            var userAnswer = findViewById<EditText>(R.id.answer)
            var stringCheck = checker(userAnswer.getText().toString())
            if (stringCheck){
                if (userAnswer.getText().toString().toInt() == answer){
                    correct++
                    counter++
                    mathPassed = true
                    userAnswer.getText().clear()
                    Log.i("TEST", "math: correct")
                }
                else{
                    counter++
                    mathPassed = true
                    userAnswer.getText().clear()
                    Log.i("TEST","math: incorrect")
                }
            }
        }
    }

    /**
     * checks if the answer provided is actually a int or a double
     * returns a boolean
     */
    fun checker(answer: String): Boolean{
        try {
            // checks if it has decimal and if it does it trys double
            // if not it trys int
            // if both fail it returns false
            if (answer.contains(".")){
                answer.toDouble()
                return true
            }else{
                answer.toInt()
                return true
            }

        }catch (e: NumberFormatException){
            return false
        }
    }

    /**
     * submit does the same thing as onCreate expect it runs math and it switches the activity
     */
    fun submit(view: View){
        // Math runs
        math()
        // checks if counter equals question
        // don't need to check if math passed because counter only goes up when math runs
        if (counter == questionCount.toInt()){
            counter = 0
            var i = Intent(this@MathScreen, endState::class.java)
            startActivity(i)
        }
        // if math passed and counter doesn't equal the question amount then it resets everything and picks new numbers
        else if (mathPassed){
            if (operatorNum == 1){
                if (difficultyNum == 1){
                    num1 = Random.nextInt(0,10)
                    num2 = Random.nextInt(0,10)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "-" + " " + num2.toString())
                }
                else if (difficultyNum == 2){
                    num1 = Random.nextInt(0,25)
                    num2 = Random.nextInt(0,25)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "-" + " " + num2.toString())
                }else if (difficultyNum == 3){
                    num1 = Random.nextInt(0,50)
                    num2 = Random.nextInt(0,50)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "-" + " " + num2.toString())
                }
            }
            else if (operatorNum == 2){
                if (difficultyNum == 1){
                    num1 = Random.nextInt(0,10)
                    num2 = Random.nextInt(0,10)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "/" + " " + num2.toString())
                }
                else if (difficultyNum == 2){
                    num1 = Random.nextInt(0,25)
                    num2 = Random.nextInt(0,25)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "/" + " " + num2.toString())
                }else if (difficultyNum == 3){
                    num1 = Random.nextInt(0,50)
                    num2 = Random.nextInt(0,50)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "/" + " " + num2.toString())
                }
            }
            else if (operatorNum == 3){
                if (difficultyNum == 1){
                    num1 = Random.nextInt(0,10)
                    num2 = Random.nextInt(0,10)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "x" + " " + num2.toString())
                }
                else if (difficultyNum == 2){
                    num1 = Random.nextInt(0,25)
                    num2 = Random.nextInt(0,25)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "x" + " " + num2.toString())
                }else if (difficultyNum == 3){
                    num1 = Random.nextInt(0,50)
                    num2 = Random.nextInt(0,50)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "x" + " " + num2.toString())
                }
            }else{
                if (difficultyNum == 1){
                    num1 = Random.nextInt(0,10)
                    num2 = Random.nextInt(0,10)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "+" + " " + num2.toString())
                }
                else if (difficultyNum == 2){
                    num1 = Random.nextInt(0,25)
                    num2 = Random.nextInt(0,25)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "+" + " " + num2.toString())
                }else if (difficultyNum == 3){
                    num1 = Random.nextInt(0,50)
                    num2 = Random.nextInt(0,50)
                    var question = findViewById<TextView>(R.id.question)
                    question.setText(num1.toString() + " " + "+" + " " + num2.toString())
                }
            }
        }
        // if math doesn't pass the user gets a notification saying to please try again
        else{
            val toast = Toast.makeText(this,"Please enter a number",Toast.LENGTH_SHORT)
            toast.show()
        }
        Log.i("Button", "final submit was pressed")
    }
}