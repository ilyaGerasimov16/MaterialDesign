package com.example.materialdesign.view.viewPager

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(private val fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(EarthFragment(), MarsFragment(), SystemFragment())


    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int) = fragments[position]


}