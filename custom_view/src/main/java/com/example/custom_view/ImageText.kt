package com.example.custom_view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class ImageText(context: Context?, attrs: AttributeSet?)
    : RelativeLayout(context, attrs) {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    init {
        inflate(context, R.layout.image_text, this)
        val attributes = context!!.obtainStyledAttributes(attrs, R.styleable.ImageText)
        imageView = findViewById(R.id.image)
        textView = findViewById(R.id.textView)
        imageView.setImageResource(attributes.getResourceId(R.styleable.ImageText_src, Color.BLACK))
        textView.text = attributes.getString(R.styleable.ImageText_text)
    }
}