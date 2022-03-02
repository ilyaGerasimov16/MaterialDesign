package com.example.materialdesign.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import com.example.materialdesign.R
import com.example.materialdesign.view.main.MainFragment

const val ThemeOne = 1
const val ThemeSecond = 2
const val ThemeThird = 3

class MainActivity : AppCompatActivity() {

    private val KEY_SP = "sp"
    private val KEY_CURRENT_THEME = "current_theme"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(getRealStyle(getCurrentTheme()))
        setContentView(R.layout.activity_test_layout)

        if(savedInstanceState == null) {
            //supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment.newInstance()).commit()
        }

        //findViewById<Button>(R.id.button1).visibility = View.GONE
        findViewById<Group>(R.id.group1).visibility = View.GONE

    }

    fun setCurrentTheme(currentTheme: Int) {
        val sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_CURRENT_THEME, currentTheme)
        editor.apply()
    }

    private fun getCurrentTheme(): Int {
        val sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE)
        return sharedPreferences.getInt(KEY_CURRENT_THEME, -1)
    }

    private fun getRealStyle(currentTheme: Int): Int {
        return when (currentTheme) {
            ThemeOne -> R.style.MyGreenTheme
            ThemeSecond -> R.style.MyRedTheme
            ThemeThird -> R.style.MyBlueTheme
            else -> 0
        }
    }

}