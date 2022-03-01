package com.example.materialdesign.view.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(private val fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOf(EarthFragment(), MarsFragment(), SystemFragment())


/*
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            EARTH  -> "Earth"
            MARS   -> "Mars"
            SYSTEM -> "System"
            else ->"null"
        }
    }*/

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int)  = fragments[position]

}