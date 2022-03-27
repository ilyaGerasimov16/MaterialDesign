package com.example.materialdesign.view.animations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.transition.*
import android.view.View
import androidx.transition.Slide
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
            val slide = Slide(Gravity.START)
            //val explode = Explode()
            slide.duration = 2000
            //explode.duration = 2000
            transitionSet.ordering = TransitionSet.ORDERING_SEQUENTIAL

            transitionSet.addTransition(slide)
            //transitionSet.addTransition(explode)

            TransitionManager.beginDelayedTransition(binding.transitionContainer, transitionSet)

            textIsVisible = !textIsVisible
            binding.text.visibility = if(textIsVisible) View.VISIBLE else View.GONE
        }
    }
}