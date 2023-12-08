package com.example.foodgroupapp.presentation.home_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodgroupapp.data.databse.models.FoodModel
import com.example.foodgroupapp.domain.GetAllFoodUseCaseImplementation
import kotlinx.coroutines.launch

class HomeScreenViewModel:ViewModel() {
    private val getAllFoodUseCase = GetAllFoodUseCaseImplementation()
    val foodLiveData:MutableLiveData<List<FoodModel>> = MutableLiveData()
    init {
        getAllFood()
    }
    private fun getAllFood(){
        viewModelScope.launch {
            val response = getAllFoodUseCase.getAllFood()
            foodLiveData.postValue(response)
        }
    }
}