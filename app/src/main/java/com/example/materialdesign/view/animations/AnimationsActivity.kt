package com.example.materialdesign.view.animations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.View
import com.example.materialdesign.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {


    private var textIsVisible = false
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val transitionSet = TransitionSet()
            val fade = Fade()
            val changeBounds = ChangeBounds()
            changeBounds.duration = 3000
            fade.duration = 2000
            transitionSet.ordering = TransitionSet.ORDERING_SEQUENTIAL
            transitionSet.addTransition(fade)
            transitionSet.addTransition(changeBounds)


            TransitionManager.beginDelayedTransition(binding.transitionContainer, transitionSet)

            textIsVisible = !textIsVisible
            binding.text.visibility = if(textIsVisible) View.VISIBLE else View.GONE
        }
    }
}