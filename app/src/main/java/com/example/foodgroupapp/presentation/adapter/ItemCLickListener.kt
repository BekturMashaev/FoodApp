package com.example.foodgroupapp.presentation.adapter

import com.example.foodgroupapp.data.databse.models.FoodModel

interface ItemCLickListener {
    fun onFoodItemClick(foodModel: FoodModel)
    fun onSendItemClick(foodModel:FoodModel)
}