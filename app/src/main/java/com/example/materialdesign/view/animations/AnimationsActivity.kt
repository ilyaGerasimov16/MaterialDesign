package com.example.materialdesign.view.animations

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.example.materialdesign.R
import com.example.materialdesign.databinding.ActivityAnimationsBinding


class AnimationsActivity : AppCompatActivity() {


    private var textIsVisible = false
    lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = MyAdapter()

    }

    inner class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
        inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_animations_recycler_item, parent,false))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.itemView.setOnClickListener{
                val transitionSet = TransitionSet()
                val explode = Explode()
                val fade = Fade()
                fade.duration = 99999999999
                explode.duration = 3000
                val rect1 = Rect()
                it.getGlobalVisibleRect(rect1)
                explode.excludeTarget(it,true)

                explode.epicenterCallback = object : Transition.EpicenterCallback(){
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return rect1
                    }

                }
                transitionSet.addTransition(explode)
                transitionSet.addTransition(fade)
                TransitionManager.beginDelayedTransition(binding.transitionContainer, transitionSet)
                binding.recyclerView.adapter = null

            }
        }

        override fun getItemCount(): Int {
            return 32
        }
    }
}