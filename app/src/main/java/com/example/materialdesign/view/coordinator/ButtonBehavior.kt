package com.example.materialdesign.view.coordinator

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

class ButtonBehavior(context: Context, attributeSet: AttributeSet?=null) : CoordinatorLayout.Behavior<View>(context,attributeSet) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        val bar = dependency as AppBarLayout
        val barY = bar.y
        val barHeight = bar.height/2
        if(kotlin.math.abs(barY) >barHeight){
            child.visibility = View.GONE
        } else{
            child.visibility = View.VISIBLE
            val alpha = (barHeight - kotlin.math.abs(barY))/barHeight
            child.alpha = alpha
        }
        return super.onDependentViewChanged(parent, child, dependency)
    }
}