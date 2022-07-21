package com.example.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class RevealAnimationActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reveal_animation)

        imageView = findViewById(R.id.image)
        progressBar = findViewById(R.id.loading_spinner)
        button = findViewById<Button?>(R.id.button).apply {
            setOnClickListener { crossFade() }
        }
    }

    private fun crossFade() {
        imageView.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .duration = 1000
        }

        progressBar.animate().apply {
            duration = 1000
            alpha(0f)
            setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    progressBar.visibility = View.GONE
                }
            })
        }
    }
}