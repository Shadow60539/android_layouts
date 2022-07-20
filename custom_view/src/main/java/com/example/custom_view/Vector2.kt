package com.example.custom_view

import android.view.MotionEvent

class Vector2 private constructor(val dx: Float, val dy: Float) {
    companion object {
        fun fromEvent(event: MotionEvent): Vector2 {
            return Vector2(event.x, event.y)
        }
    }

    override fun toString(): String {
        return "x -> $dx y -> $dy"
    }
}