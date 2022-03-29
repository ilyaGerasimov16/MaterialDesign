package com.example.materialdesign.view.animations

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
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            flag = !flag

            val titles: MutableList<String> = ArrayList()

            repeat(5){
                titles.add(("Item ${it}"))
            }
            titles.shuffle()
            TransitionManager.beginDelayedTransition(binding.transitionsContainer, ChangeBounds())
            binding.transitionsContainer.removeAllViews()
            titles.forEach{
                binding.transitionsContainer.addView(TextView(this).apply {
                    text = it
                    textSize = 20f
                    transitionName = it
                    gravity = Gravity.CENTER_HORIZONTAL
                })
            }

        }
    }


}