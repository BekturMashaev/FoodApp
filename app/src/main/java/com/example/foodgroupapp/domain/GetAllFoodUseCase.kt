package com.example.foodgroupapp.domain

import com.example.foodgroupapp.data.databse.models.FoodModel

interface GetAllFoodUseCase {
    suspend fun getAllFood(): List<FoodModel>
}