package com.example.foodgroupapp.presentation.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodgroupapp.R
import com.example.foodgroupapp.data.databse.models.FoodModel
import com.example.foodgroupapp.databinding.FragmentHomeScreenBinding
import com.example.foodgroupapp.presentation.adapter.FoodAdapter
import com.example.foodgroupapp.presentation.adapter.ItemCLickListener
import com.google.android.material.snackbar.Snackbar

class HomeScreenFragment : Fragment(), ItemCLickListener {
    private val binding: FragmentHomeScreenBinding by lazy {
        FragmentHomeScreenBinding.inflate(layoutInflater)
    }
    private val adapter: FoodAdapter by lazy {
        FoodAdapter(this)
    }
    private lateinit var viewModel: HomeScreenViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[HomeScreenViewModel::class.java]
        setUpStatusColors()
        setUpDataListener()
        binding.cartIv.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeScreenFragment_to_cartScreenFragment
            )
        }
    }

    private fun setUpDataListener() {
        viewModel.foodLiveData.observe(viewLifecycleOwner) { foodList ->
            adapter.updateList(foodList)
            binding.foodRv.adapter = adapter
        }
    }

    private fun setUpStatusColors() {
        requireActivity().window?.statusBarColor = resources.getColor(R.color.home_screen_color)
        requireActivity().window?.navigationBarColor = resources.getColor(R.color.white)
    }

    override fun onFoodItemClick(foodModel: FoodModel) {
        findNavController().navigate(
            R.id.action_homeScreenFragment_to_itemViewFragment, bundleOf(FOOD_KEY to foodModel)
        )
    }

    override fun onIconClick(index: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        const val FOOD_KEY = "FOOD_KEY"
    }
}