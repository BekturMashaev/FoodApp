package com.example.foodgroupapp.domain

import com.example.foodgroupapp.data.databse.models.FoodModel
import com.example.foodgroupapp.data.databse.repository.GetAllFoodRepositoryImplementation

class GetAllFoodUseCaseImplementation : GetAllFoodUseCase {
    private val foodRepository = GetAllFoodRepositoryImplementation()
    override suspend fun getAllFood(): List<FoodModel> {
        return foodRepository.getAllFoodAsync()
    }
}