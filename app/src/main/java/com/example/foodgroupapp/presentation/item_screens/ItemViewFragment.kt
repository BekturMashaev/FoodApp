package com.example.foodgroupapp.presentation.item_screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.foodgroupapp.R
import com.example.foodgroupapp.data.databse.models.FoodModel
import com.example.foodgroupapp.databinding.FragmentItemViewBinding
import com.example.foodgroupapp.presentation.home_screen.HomeScreenFragment

class ItemViewFragment : Fragment() {
    private val binding by lazy {
        FragmentItemViewBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backPressedDispatcher()
        val foodModel = arguments?.getSerializable(HomeScreenFragment.FOOD_KEY) as? FoodModel
        foodModel?.let { setUpViews(it) }
        setUpStatusColors()
    }

    private fun backPressedDispatcher() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack()
        }
    }
    private fun setUpStatusColors() {
        requireActivity().window?.statusBarColor = resources.getColor(R.color.white)
        requireActivity().window?.navigationBarColor = resources.getColor(R.color.white)
    }

    private fun setUpViews(foodModel: FoodModel) {
        binding.apply {
            Glide.with(requireContext()).load(foodModel.foodImage).into(foodPicture)
            foodNameTxt.text = foodModel.foodName
            foodDescriptionText.text = foodModel.foodDescription
            foodPriceTv.text = "${foodModel.foodPrice}$"
        }
    }
}