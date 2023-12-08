package com.example.foodgroupapp.data.databse.repository

import com.example.foodgroupapp.data.databse.models.FoodModel

interface GetAllFoodRepository {
    suspend fun getAllFoodAsync(): List<FoodModel>
}