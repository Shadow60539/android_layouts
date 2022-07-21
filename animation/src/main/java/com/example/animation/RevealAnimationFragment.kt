package com.example.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

class RevealAnimationFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reveal_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.image)
        progressBar = view.findViewById(R.id.loading_spinner)
        button = view.findViewById<Button?>(R.id.button).apply {
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