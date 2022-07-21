package com.example.animation

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager

class MainActivity : AppCompatActivity() {

    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var transition: Transition
    private lateinit var rootFrameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootFrameLayout = findViewById<FrameLayout>(R.id.rootFrameLayout)
        scene1 = Scene.getSceneForLayout(rootFrameLayout, R.layout.scene_1, this)
        scene2 = Scene.getSceneForLayout(rootFrameLayout, R.layout.scene_2, this)

        scene1.enter()
        transition = TransitionInflater.from(this).inflateTransition(R.transition.fade)

        rootFrameLayout.setOnClickListener{
            navigate()
        }
    }

    private fun showFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.rootFrameLayout, fragment)
        ft.commit()
    }

    private fun navigate() {
        if (Scene.getCurrentScene(rootFrameLayout)==scene1) {
            TransitionManager.go(scene2, transition)
        } else {
            TransitionManager.go(scene1, transition)
        }
    }
}