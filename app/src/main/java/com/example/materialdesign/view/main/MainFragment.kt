package com.example.materialdesign.view.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentMainBinding
import com.example.materialdesign.databinding.FragmentMainStartBinding
import com.example.materialdesign.view.MainActivity
import com.example.materialdesign.view.settings.SettingsFragment
import com.example.materialdesign.viewModel.PictureOfTheDayData
import com.example.materialdesign.viewModel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment() {

    private lateinit var bottomSheetBehavior:BottomSheetBehavior<ConstraintLayout>
    private var _binding:FragmentMainBinding? = null
    private val binding:FragmentMainBinding
    get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    private val viewModelPOD: PictureOfTheDayViewModel by lazy{
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelPOD.getData().observe(viewLifecycleOwner, {
            renderData(it)
        })
        viewModelPOD.sendRequest()

        openWikiPage()

        setMenu()

        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.twoDaysAgo ->{viewModelPOD.sendRequest(takeDate(-2))}
                R.id.yesterday ->{viewModelPOD.sendRequest(takeDate(-1))}
                R.id.today ->{viewModelPOD.sendRequest()}
            }
        }
    }

    private fun takeDate(count: Int): String {
        val currentDate = Calendar.getInstance()
        currentDate.add(Calendar.DAY_OF_MONTH, count)
        val format1 = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        format1.timeZone = TimeZone.getTimeZone("EST")
        return format1.format(currentDate.time)
    }

    private fun openWikiPage() {
        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            })
        }
    }

    private fun setMenu() {
        (requireActivity() as MainActivity).setSupportActionBar(binding.bottomAppBar)
        setHasOptionsMenu(true)

        bottomSheetBehavior = BottomSheetBehavior.from(binding.included.bottomSheetContainer)


        var isMain = true
        binding.fab.setOnClickListener {
            if (isMain) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                binding.bottomAppBar.navigationIcon = null
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.fab.setImageResource(R.drawable.ic_back_fab)
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar_other_screen)
            } else {
                binding.bottomAppBar.navigationIcon = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_hamburger_menu_bottom_bar
                )
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.fab.setImageResource(R.drawable.ic_plus_fab)
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            isMain = !isMain
        }
    }

    private fun showToastOnError(text:String){
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    private fun renderData(pictureOfTheDayData: PictureOfTheDayData){
        when(pictureOfTheDayData){
            is PictureOfTheDayData.Error -> {
                binding.loadingLayout.visibility = View.GONE
                showToastOnError("$pictureOfTheDayData.error.message")
            }
            is PictureOfTheDayData.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is PictureOfTheDayData.Success -> {
                binding.loadingLayout.visibility = View.GONE
                binding.imageView.load(pictureOfTheDayData.serverResponse.url){
                    placeholder(R.drawable.ic_no_photo_vector)
                }
                binding.included.bottomSheetDescriptionHeader.text = pictureOfTheDayData.serverResponse.title
                binding.included.bottomSheetDescription.text = pictureOfTheDayData.serverResponse.explanation
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.app_bar_fav->{
                Toast.makeText(requireContext(),"app_bar_fav",Toast.LENGTH_SHORT).show()
            }
            R.id.app_bar_settings->{
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container,SettingsFragment.newInstance()).addToBackStack(null).commit()
            }
            android.R.id.home->{
                BottomNavigationDrawerFragment().show(requireActivity().supportFragmentManager,"")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}