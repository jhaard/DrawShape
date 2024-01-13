package com.example.drawshape

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import com.example.drawshape.databinding.FragmentDisplayBinding

class DisplayFragment() : Fragment() {

    private lateinit var surface: SurfaceView
    private lateinit var binding: FragmentDisplayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayBinding.inflate(layoutInflater)

        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        surface = view.findViewById(binding.surfaceView.id)

    }

    // Updatera input och byt ut aktuell shape
    fun updateView(shape: Shape) {
        val canvas = surface.holder.lockCanvas()

        canvas.drawColor(Color.BLACK)
        shape.draw(canvas)

        surface.holder.unlockCanvasAndPost(canvas)

        println("Reached Display-fragment")
    }
}





