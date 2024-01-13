package com.example.drawshape

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import kotlin.random.Random

class Triangle : Shape {

    private val paint = Paint()
    private val path = Path()

    private var point1x = 0f
    private var point1y = 0f
    private var point2x = 0f
    private var point2y = 0f
    private var point3x = 0f
    private var point3y = 0f

    override fun draw(canvas: Canvas) {
        paint.color = Random.nextInt()
        paint.alpha = 255

        point1x = Random.nextDouble(0.0, canvas.width.toDouble()).toFloat()
        point1y = Random.nextDouble(0.0, canvas.height.toDouble()).toFloat()
        point2x = Random.nextDouble(0.0, canvas.width.toDouble()).toFloat()
        point2y = Random.nextDouble(0.0, canvas.height.toDouble()).toFloat()
        point3x = Random.nextDouble(0.0, canvas.width.toDouble()).toFloat()
        point3y = Random.nextDouble(0.0, canvas.height.toDouble()).toFloat()

        path.moveTo(point1x, point1y)
        path.lineTo(point2x, point2y)
        path.lineTo(point3x, point3y)
        path.close()

        canvas.drawPath(path, paint)

        val stroke = Paint().apply {
            color = Color.WHITE
            style = Paint.Style.STROKE
            strokeWidth = 7f
        }
        canvas.drawPath(path, stroke)
    }
}