package com.example.materialdesign.view.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentSettingsBinding
import com.example.materialdesign.view.MainActivity
import com.example.materialdesign.view.ThemeOne
import com.example.materialdesign.view.ThemeSecond
import com.example.materialdesign.view.ThemeThird
import com.google.android.material.chip.Chip

class SettingsFragment : Fragment() {

    private lateinit var parentActivity: MainActivity

    private var _binding:FragmentSettingsBinding? = null
    private val binding:FragmentSettingsBinding
    get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = requireActivity() as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chipGroup.setOnCheckedChangeListener{group,checkedId ->
            binding.chipGroup.findViewById<Chip>(checkedId)?.let{ it->
                Toast.makeText(requireContext(),"${it.text}${checkedId}",Toast.LENGTH_SHORT).show()
            }
        }
        binding.chipEntry.setOnCloseIconClickListener {
            Toast.makeText(requireContext(),"chipEntry close",Toast.LENGTH_SHORT).show()
        }
        onSelectItemMenu()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onSelectItemMenu() {
        binding.bNView.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.theme_1 -> {
                    parentActivity.setCurrentTheme(ThemeOne)
                    parentActivity.recreate()
                    showToastOnChangeTheme()
                }
                R.id.theme_2 -> {
                    parentActivity.setCurrentTheme(ThemeSecond)
                    parentActivity.recreate()
                    showToastOnChangeTheme()
                }
                R.id.theme_3 -> {
                    parentActivity.setCurrentTheme(ThemeThird)
                    parentActivity.recreate()
                    showToastOnChangeTheme()
                }
            }
            true
        }
    }

    private fun showToastOnChangeTheme(){
        Toast.makeText(requireContext(),"Тема изменена", Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}