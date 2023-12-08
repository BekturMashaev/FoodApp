package com.example.foodgroupapp.data.databse.repository

import com.example.foodgroupapp.data.databse.fakeData.foodFakeData
import com.example.foodgroupapp.data.databse.models.FoodModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllFoodRepositoryImplementation : GetAllFoodRepository {
    override suspend fun getAllFoodAsync(): List<FoodModel> =
        withContext(Dispatchers.IO) {
            foodFakeData()
        }
}