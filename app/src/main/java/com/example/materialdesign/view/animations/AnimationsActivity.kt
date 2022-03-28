package com.example.materialdesign.view.animations

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

        binding.imageView.setOnClickListener{
            flag = !flag

            val changeImageTransform = ChangeImageTransform()
            changeImageTransform.duration = 3000
            TransitionManager.beginDelayedTransition(binding.transitionContainer, changeImageTransform)
            if (flag){
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            } else {
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }
        }
    }


}