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
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.example.materialdesign.R
import com.example.materialdesign.databinding.ActivityAnimationsBinding
import com.example.materialdesign.databinding.ActivityAnimationsBonusStartBinding


class AnimationsActivity : AppCompatActivity() {


    private var flag = true
    private val duration = 1000L

    lateinit var binding: ActivityAnimationsBonusStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backgroundImage.setOnClickListener{
            flag = !flag
            if (flag){
                val constraintSet = ConstraintSet()
                val changeBounds = ChangeBounds()
                changeBounds.duration = 1000L
                changeBounds.interpolator = AnticipateOvershootInterpolator(1f)
                constraintSet.clone(this,R.layout.activity_animations_bonus_start)
                TransitionManager.beginDelayedTransition(binding.constraintContainer, changeBounds)
                constraintSet.applyTo(binding.constraintContainer)
            } else{
                val constraintSet = ConstraintSet()
                val changeBounds = ChangeBounds()
                changeBounds.duration = 1000L
                changeBounds.interpolator = AnticipateOvershootInterpolator(1f)
                constraintSet.clone(this,R.layout.activity_animations_bonus_start)
                constraintSet.connect(R.id.title, ConstraintSet.END, R.id.constraint_container,
                    ConstraintSet.END)
                constraintSet.connect(R.id.title, ConstraintSet.TOP, R.id.constraint_container,
                    ConstraintSet.TOP)
                constraintSet.connect(R.id.title, ConstraintSet.START, R.id.constraint_container,
                    ConstraintSet.START)
                TransitionManager.beginDelayedTransition(binding.constraintContainer, changeBounds)
                constraintSet.applyTo(binding.constraintContainer)
            }

        }

    }
}