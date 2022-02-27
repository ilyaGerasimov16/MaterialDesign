package com.example.materialdesign.view.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.materialdesign.R
import com.example.materialdesign.databinding.BottomNavigationLayoutBinding
import com.example.materialdesign.view.MainActivity
import com.example.materialdesign.view.ThemeOne
import com.example.materialdesign.view.ThemeSecond
import com.example.materialdesign.view.ThemeThird
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNavigationDrawerFragment:BottomSheetDialogFragment() {

    private lateinit var parentActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = requireActivity() as MainActivity
    }

    private var _binding: BottomNavigationLayoutBinding? = null
    private val binding:BottomNavigationLayoutBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomNavigationLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSelectItemMenu()
    }

    private fun onSelectItemMenu() {
        binding.navigationView.setNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.theme_1 -> {
                    parentActivity.setCurrentTheme(ThemeOne)
                    parentActivity.recreate()
                    showToastOnChangeTheme()
                    activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                }
                R.id.theme_2 -> {
                    parentActivity.setCurrentTheme(ThemeSecond)
                    parentActivity.recreate()
                    showToastOnChangeTheme()
                    activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                }
                R.id.theme_3 -> {
                    parentActivity.setCurrentTheme(ThemeThird)
                    parentActivity.recreate()
                    showToastOnChangeTheme()
                    activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                }
            }
            true
        }
    }

    private fun showToastOnChangeTheme(){
        Toast.makeText(requireContext(),"Тема изменена", Toast.LENGTH_SHORT).show()
    }
}