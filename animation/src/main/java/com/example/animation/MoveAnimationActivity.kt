package com.example.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MoveAnimationActivity : AppCompatActivity() {

    private lateinit var cardView: CardView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_animation)

        cardView = findViewById(R.id.cardView)
        button = findViewById<Button?>(R.id.button).also {
            it.setOnClickListener {
                ObjectAnimator.ofFloat(cardView, "translationY",-200f).apply {
                    duration = 400
                    start()
                }
            }
        }

    }
}