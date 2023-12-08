package com.example.foodgroupapp.data.databse.preference

import android.content.Context
import com.example.foodgroupapp.data.databse.models.FoodModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
private const val SHARED_PREFERENCES_IN_CART = "SHARED_PREFERENCES_IN_CART"

class CartPreferences(
    private val context: Context
) {
    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    fun getAllFood(): List<FoodModel> {
        val gson = Gson()
        val json = sharedPreferences.getString(SHARED_PREFERENCES_IN_CART, null)
        val type: Type = object : TypeToken<ArrayList<FoodModel?>?>() {}.type
        val foodList = gson.fromJson<ArrayList<FoodModel>>(json, type)
        return foodList ?: emptyList()
    }

    fun saveFood(foodModel: FoodModel) {
        val food = getAllFood().toMutableList()
        food.add(0, foodModel)
        val foodGson = Gson().toJson(food)
        sharedPreferences.edit().putString(
            SHARED_PREFERENCES_IN_CART, foodGson
        ).apply()
    }

    fun deleteFoodByIndex(index: Int) {
        val getAllFood = getAllFood().toMutableList()
        if (index in 0 until getAllFood.size) {
            getAllFood.removeAt(index)
            val foodGsonString = Gson().toJson(getAllFood)
            sharedPreferences.edit().putString(SHARED_PREFERENCES_IN_CART, foodGsonString).apply()
        }
    }

    fun deleteAllFood() {
        sharedPreferences.edit().clear().apply()
    }
}