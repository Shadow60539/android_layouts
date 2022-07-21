package com.example.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class MoveAnimationFragment : Fragment() {

    private lateinit var cardView: CardView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.move_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardView = view.findViewById(R.id.cardView)
        button = view.findViewById<Button?>(R.id.button).also {
            it.setOnClickListener {
                ObjectAnimator.ofFloat(cardView, "translationY",-200f).apply {
                    duration = 400
                    start()
                }
            }
        }
    }
}