package com.example.materialdesign.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.materialdesign.R
import com.example.materialdesign.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment.newInstance()).commit()
        }
    }
}