package com.example.materialdesign.view.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialdesign.databinding.FragmentSettingsBinding
import com.google.android.material.chip.Chip

class SettingsFragment : Fragment() {


    private var _binding:FragmentSettingsBinding? = null
    private val binding:FragmentSettingsBinding
    get() = _binding!!


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
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}