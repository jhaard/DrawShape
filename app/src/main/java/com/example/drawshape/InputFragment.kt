package com.example.drawshape

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drawshape.databinding.FragmentInputBinding
import java.lang.Exception

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding
    private var inputListener: OnInputListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            inputListener = context as OnInputListener
            println("Successfully implemented interface")
        } catch (e: Exception) {
            println("Not implemented")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(layoutInflater)

        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Skapa rätt figur beroende på knapp
        binding.btnCircle.setOnClickListener {
            inputListener?.onInputChange(Circle())
        }

        binding.btnTriangle.setOnClickListener {
            inputListener?.onInputChange(Triangle())
        }

        binding.btnRect.setOnClickListener {
            inputListener?.onInputChange(Rectangle())
        }
    }

    override fun onDetach() {
        super.onDetach()
        inputListener = null
    }

    interface OnInputListener {
        fun onInputChange(shape: Shape)
    }
}