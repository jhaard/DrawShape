package com.example.drawshape

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Circle : Shape {

    private var paint = Paint()
    private var size = Random.nextDouble(10.0, 250.0)
    private var posX = 0f
    private var posY = 0f

    override fun draw(canvas: Canvas) {
        paint.color = Random.nextInt()
        paint.alpha = 255

        posX = Random.nextDouble(size, canvas.width - size).toFloat()
        posY = Random.nextDouble(size, canvas.height - size).toFloat()

        canvas.drawCircle(posX, posY, size.toFloat(), paint)

        val stroke = Paint().apply {
            color = Color.WHITE
            style = Paint.Style.STROKE
            strokeWidth = 7f
        }
        canvas.drawCircle(posX, posY, size.toFloat(), stroke)
    }
}
