package com.example.materialdesign.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.materialdesign.R
import com.example.materialdesign.databinding.BottomNavigationLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNavigationDrawerFragment:BottomSheetDialogFragment() {

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
        binding.navigationView.setNavigationItemSelectedListener { menu->
            when(menu.itemId){
                R.id.navigation_one->{
                    Toast.makeText(requireContext(),"navigation_one", Toast.LENGTH_SHORT).show()
                    activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                }
                R.id.navigation_two->{
                    Toast.makeText(requireContext(),"navigation_two", Toast.LENGTH_SHORT).show()
                    activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
                }
            }
            true
        }
    }
}