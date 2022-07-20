package com.example.custom_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() , MyCustomListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<MyCustomView>(R.id.myCustomView).setListener(this)
    }

    override fun onSeatSelected(seats: MutableSet<Vector2>) {
        Log.d("Seats", seats.size.toString())
    }
}