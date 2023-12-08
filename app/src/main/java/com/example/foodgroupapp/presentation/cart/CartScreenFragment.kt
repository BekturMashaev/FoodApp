package com.example.foodgroupapp.presentation.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodgroupapp.R
import com.example.foodgroupapp.data.databse.models.FoodModel
import com.example.foodgroupapp.data.databse.preference.CartPreferences
import com.example.foodgroupapp.databinding.FragmentCartScreenBinding
import com.example.foodgroupapp.presentation.adapter.FoodAdapter
import com.example.foodgroupapp.presentation.adapter.ItemCLickListener
import com.example.foodgroupapp.presentation.home_screen.HomeScreenFragment

class CartScreenFragment : Fragment(), ItemCLickListener {
    private val sharedPreferences: CartPreferences by lazy {
        CartPreferences(requireContext())
    }
    private val adapter: FoodAdapter by lazy {
        FoodAdapter(this, true)
    }
    private val binding by lazy {
        FragmentCartScreenBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewsAndAdapter()
        buttonsAndDispatchers()
    }

    private fun setUpViewsAndAdapter() {
        adapter.updateList(sharedPreferences.getAllFood())
        binding.foodCartRv.adapter = adapter
    }

    override fun onFoodItemClick(foodModel: FoodModel) {
        findNavController().navigate(
            R.id.action_cartScreenFragment_to_itemViewFragment,
            bundleOf(HomeScreenFragment.FOOD_KEY to foodModel)
        )
    }

    override fun onIconClick(index: Int) {
        sharedPreferences.deleteFoodByIndex(index)
        setUpViewsAndAdapter()
    }

    private fun buttonsAndDispatchers() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack()
        }
        binding.backIv.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.deleteIv.setOnClickListener{
            sharedPreferences.deleteAllFood()
        }
    }
}