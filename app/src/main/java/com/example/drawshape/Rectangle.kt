package com.example.drawshape

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Rectangle : Shape {

    private val paint = Paint()
    private var size = Random.nextDouble(10.0, 200.0)
    private var left = 0f
    private var right = 0f
    private var bottom = 0f
    private var top = 0f

    override fun draw(canvas: Canvas) {
        paint.color = Random.nextInt()
        paint.alpha = 255

        left = Random.nextDouble(0.0, canvas.width - size).toFloat()
        right = Random.nextDouble(0.0 + size, canvas.width.toDouble()).toFloat()
        bottom = Random.nextDouble(0 + size, canvas.height.toDouble()).toFloat()
        top = Random.nextDouble(0.0, canvas.height - size).toFloat()

        canvas.drawRect(left, top, right, bottom, paint)

        val stroke = Paint().apply {
            color = Color.WHITE
            style = Paint.Style.STROKE
            strokeWidth = 7f
        }
        canvas.drawRect(left, top, right, bottom, stroke)
    }
}