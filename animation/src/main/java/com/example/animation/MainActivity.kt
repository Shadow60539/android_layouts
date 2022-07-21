package com.example.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(MotionLayoutFragment())
    }

    private fun showFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.rootFrameLayout, fragment)
        ft.commit()
    }
}