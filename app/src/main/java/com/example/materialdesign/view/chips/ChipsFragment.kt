package com.example.materialdesign.view.chips

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentChipsBinding
import com.example.materialdesign.databinding.FragmentMainBinding
import com.example.materialdesign.view.MainActivity
import com.example.materialdesign.viewModel.PictureOfTheDayData
import com.example.materialdesign.viewModel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip

class ChipsFragment : Fragment() {


    private var _binding:FragmentChipsBinding? = null
    val binding:FragmentChipsBinding
    get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChipsBinding.inflate(inflater,container,false)
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
        fun newInstance() = ChipsFragment()
    }
}