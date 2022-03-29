package com.example.materialdesign.view.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.example.materialdesign.R
import com.example.materialdesign.databinding.ActivityAnimationsBinding


class AnimationsActivity : AppCompatActivity() {


    private var flag = false
    private val duration = 1000L
    private val rotation = 405f
    private val translationY = -200f
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.transparentBackground.alpha = 0f
        binding.optionOneContainer.alpha = 0f
        binding.optionOneContainer.isClickable = false
        binding.optionTwoContainer.alpha = 0f
        binding.optionTwoContainer.isClickable = false

        binding.fab.setOnClickListener{
            flag = !flag
            if (flag){
                ObjectAnimator.ofFloat(binding.plusImageview,View.ROTATION,
                    0f,rotation).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,View.TRANSLATION_Y,
                    0f,translationY*2).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,View.TRANSLATION_Y,
                    0f,translationY).setDuration(duration).start()

                binding.optionOneContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionOneContainer.isClickable = true
                            super.onAnimationEnd(animation)
                        }
                    })

                binding.optionTwoContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionTwoContainer.isClickable = true
                            super.onAnimationEnd(animation)
                        }
                    })

                binding.transparentBackground.animate()
                    .alpha(0.8f)
                    .setDuration(duration)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.transparentBackground.isClickable = true
                            super.onAnimationEnd(animation)
                        }
                    })

            } else {
                ObjectAnimator.ofFloat(binding.plusImageview,View.ROTATION,
                    rotation,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,View.TRANSLATION_Y,
                    translationY*2,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,View.TRANSLATION_Y,
                    translationY,0f).setDuration(duration).start()

                binding.optionOneContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionOneContainer.isClickable = false
                            super.onAnimationEnd(animation)
                        }
                    })

                binding.optionTwoContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionTwoContainer.isClickable = false
                            super.onAnimationEnd(animation)
                        }
                    })

                binding.transparentBackground.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object: AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.transparentBackground.isClickable = false
                            super.onAnimationEnd(animation)
                        }
                    })

            }
        }
    }


}