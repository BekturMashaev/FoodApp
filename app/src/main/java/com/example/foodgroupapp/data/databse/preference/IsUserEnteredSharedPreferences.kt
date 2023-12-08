package com.example.foodgroupapp.data.databse.preference

import android.content.Context

private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
private const val SHARED_PREFERENCES_IS_ENTERED_KEY = "SHARED_PREFERENCES_IS_ENTERED_KEY"

class IsUserEnteredSharedPreferences(
    private val context: Context
) {
    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    fun getUserFirstEntrance(): Boolean {
        return sharedPreferences.getBoolean(SHARED_PREFERENCES_IS_ENTERED_KEY, false)
    }

    fun setUserFirstEntrance(userFirstEntrance: Boolean) {
        sharedPreferences.edit().putBoolean(SHARED_PREFERENCES_IS_ENTERED_KEY, userFirstEntrance)
            .apply()
    }
}