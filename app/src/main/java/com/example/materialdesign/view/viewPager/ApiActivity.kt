package com.example.materialdesign.view.viewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.materialdesign.R
import com.example.materialdesign.databinding.ActivityApiBinding


class ApiActivity : AppCompatActivity() {

    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tabLayout.getTabAt(EARTH)?.setIcon(R.drawable.ic_earth)
        binding.tabLayout.getTabAt(MARS)?.setIcon(R.drawable.ic_mars)
        binding.tabLayout.getTabAt(SYSTEM)?.setIcon(R.drawable.ic_system)

    }

}