package com.example.custom_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlin.math.min

class MyCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val TAG = this.javaClass.simpleName

    var customListener: MyCustomListener? = null

    private val outlinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GRAY
        style = Paint.Style.STROKE
        strokeWidth = 5F
    }

    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.FILL_AND_STROKE
        strokeWidth = 5F
    }

    private val selectedSeats: MutableSet<Vector2> = mutableSetOf<Vector2>()


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.d(TAG, "onMeasure")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d(TAG, "onLayout")
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        Log.d(TAG, "onDraw")
        super.onDraw(canvas)

        val side = min(width,height)/8
        for (dy in 0..height step side*2) {
            for (dx in 0..width step side*2) {
                val left = dx.toFloat()
                val top = dy.toFloat()
                val right = (left + side).toFloat()
                val bottom = (top + side).toFloat()
                val rectF = RectF(left,top, right, bottom)

                if (isSeatOverflow(left, top, right, bottom)) continue

                canvas?.drawRoundRect(
                    rectF,
                    10F,
                    10F,
                    if (isSeatSelected(left, top, right, bottom)) fillPaint else outlinePaint
                )

            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        Log.d(TAG, "onSizeChanged ($oldh, $oldw) -> ($h, $w)")
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            selectedSeats.add(Vector2.fromEvent(event))
            customListener?.onSeatSelected(selectedSeats)
            invalidate() // expensive (alternative?)
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }

    fun setListener(listener: MyCustomListener) {
        customListener = listener
    }

    private fun isSeatOverflow(left: Float, top: Float, right: Float, bottom: Float) : Boolean {
        if (right >= width || bottom >= height) return true
        return false
    }

    private fun isSeatSelected(left: Float, top: Float, right: Float, bottom: Float): Boolean {
        for (seat in selectedSeats) {
            if (seat.dx in left..right && seat.dy in top..bottom) {
                return true
            }
        }

        return false
    }

}