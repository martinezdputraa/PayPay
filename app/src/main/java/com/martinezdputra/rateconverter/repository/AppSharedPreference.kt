package com.martinezdputra.rateconverter.repository

import android.content.SharedPreferences
import javax.inject.Inject

class AppSharedPreference @Inject constructor(private val sharedPreference: SharedPreferences) {

    fun updateLastFetchMillis(prefix: String): Boolean {
        val currentMillis = System.currentTimeMillis()
        val editor = sharedPreference.edit()
        editor.putLong(prefix + LAST_FETCH_KEY, currentMillis)
        return editor.commit()
    }

    fun isShouldUpdateCache(prefix: String, minuteDiffThreshold: Long): Boolean {
        val currentMillis = System.currentTimeMillis()
        val lastUpdateMillis = sharedPreference.getLong(prefix + LAST_FETCH_KEY, 0)
        val diffInSecond = (currentMillis - lastUpdateMillis) / 1000
        val diffInMinute = diffInSecond / 60
        return diffInMinute > minuteDiffThreshold
    }

    fun setCacheExist(prefix: String): Boolean {
        val editor = sharedPreference.edit()
        editor.putBoolean(prefix + ENTRY_EXIST_KEY, true)
        return editor.commit()
    }

    fun checkIfCacheExist(prefix: String): Boolean {
        return sharedPreference.getBoolean(prefix + ENTRY_EXIST_KEY, false)
    }

    companion object {
        private const val LAST_FETCH_KEY = "last_api_fetch_sp_key"
        private const val ENTRY_EXIST_KEY = "entry_exist_sp_key"

        const val SHARED_PREFERENCE_FILE_NAME = "paypay.sharedpreferences"
    }
}