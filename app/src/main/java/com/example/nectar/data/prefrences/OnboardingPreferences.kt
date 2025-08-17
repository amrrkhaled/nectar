package com.example.nectar.data.prefrences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore(name = "app_prefs")

class OnboardingPreferences(private val context: Context) {

    private val ONBOARDING_KEY = booleanPreferencesKey("onboarding_complete")

    val isOnboardingCompleted: Flow<Boolean> = context.dataStore.data
        .map { prefs ->
            prefs[ONBOARDING_KEY] ?: false
        }

    suspend fun setOnboardingCompleted() {
        context.dataStore.edit { prefs ->
            prefs[ONBOARDING_KEY] = true
        }
    }
}