package com.example.materialdesign.view.viewPager

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

const val EARTH = 0
const val MARS = 1
const val SYSTEM = 2

class ViewPagerAdapter(private val fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(EarthFragment(), MarsFragment(), SystemFragment())


    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            EARTH  -> "Earth"
            MARS   -> "Mars"
            SYSTEM -> "System"
            else ->"null"
        }
    }

}