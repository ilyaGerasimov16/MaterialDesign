package com.example.materialdesign.view.bottomNavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialdesign.R
import com.example.materialdesign.databinding.ActivityApiBinding
import com.example.materialdesign.databinding.ActivityApiBottomBinding
import com.example.materialdesign.view.viewPager.EarthFragment
import com.example.materialdesign.view.viewPager.MarsFragment
import com.example.materialdesign.view.viewPager.SystemFragment
import com.google.android.material.badge.BadgeDrawable


class ApiBottomActivity : AppCompatActivity() {

    lateinit var binding: ActivityApiBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_view_earth->{
                    navigateTo(EarthFragment())
                    true
                }
                R.id.bottom_view_mars->{
                    navigateTo(MarsFragment())
                    true
                }
                R.id.bottom_view_system->{
                    navigateTo(SystemFragment())
                    true
                }
                else-> true
            }
        }

        binding.bottomNavigationView.selectedItemId = R.id.bottom_view_mars

        val badge = binding.bottomNavigationView.getOrCreateBadge(R.id.bottom_view_mars)
        badge.number = 10000
        badge.maxCharacterCount = 5
        badge.badgeGravity = BadgeDrawable.TOP_START
        //binding.bottomNavigationView.removeBadge(R.id.bottom_view_mars)  удаление badge
    }

    private fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}