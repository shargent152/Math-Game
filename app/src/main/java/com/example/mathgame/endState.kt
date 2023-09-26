package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class endState : AppCompatActivity() {
    /**
     * onCreate puts up on the screen how many questions the user got right
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_state)
        var endText = findViewById<TextView>(R.id.endingtext)
        endText.setText("You Got " + correct.toString() + " Out of " + questionCount + " Correct")
        //resets question count
    }

    /**
     * when pressed sends the user back to the main state to be able to redo the game
     */
    fun TryAgain(view: View) {
        var i = Intent(this@endState, MainActivity::class.java)
        startActivity(i)
        Log.i("Button","Try again was pushed")
    }
}