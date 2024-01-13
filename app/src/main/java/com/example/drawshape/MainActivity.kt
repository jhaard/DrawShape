package com.example.drawshape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drawshape.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), InputFragment.OnInputListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.displayContainer.id, DisplayFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(binding.inputContainer.id, InputFragment())
            .commit()
    }

    // Kommunikation via interface och anropa updateView(shape) i display-fragmentet
    override fun onInputChange(shape: Shape) {
        val fragment = supportFragmentManager.findFragmentById(R.id.display_container) as DisplayFragment?

        fragment?.updateView(shape) ?: println("Did not call...")
    }
}