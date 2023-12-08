package com.example.foodgroupapp.presentation.welcome_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodgroupapp.R
import com.example.foodgroupapp.databinding.FragmentWelcomeScreenBinding
import com.example.foodgroupapp.data.databse.preference.IsUserEnteredSharedPreferences

class WelcomeScreenFragment : Fragment() {
    private val binding:FragmentWelcomeScreenBinding by lazy {
        FragmentWelcomeScreenBinding.inflate(layoutInflater)
    }
    private val sharedPreferences: IsUserEnteredSharedPreferences by lazy {
        IsUserEnteredSharedPreferences(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpFunctions()
    }

    private fun setUpFunctions() {
        if (sharedPreferences.getUserFirstEntrance()) {
            findNavController().navigate(
                R.id.action_welcomeScreenFragment_to_homeScreenFragment
            )
        } else {
            binding.getStartedBtn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_welcomeScreenFragment_to_homeScreenFragment
                )
                sharedPreferences.setUserFirstEntrance(true)
            }
        }
    }
}