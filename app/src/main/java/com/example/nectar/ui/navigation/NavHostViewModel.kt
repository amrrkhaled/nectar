package com.example.nectar.ui.navigation


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.data.preferences.OnboardingPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavHostViewModel @Inject constructor(
    private val onboardingPreferences: OnboardingPreferences
) : ViewModel() {

    private val _isOnboardingCompleted = MutableStateFlow<Boolean?>(null)
    val isOnboardingCompleted: StateFlow<Boolean?> = _isOnboardingCompleted

    init {
        viewModelScope.launch {
            onboardingPreferences.isOnboardingCompleted.collect { completed ->
                _isOnboardingCompleted.value = completed
                _ready.value = true
            }
        }
    }

    private val _ready = MutableStateFlow(false)
    val ready: StateFlow<Boolean> = _ready

    suspend fun completeOnboarding() {
        Log.d("NavHostViewModel", "Completing onboarding")
        onboardingPreferences.setOnboardingCompleted()
    }
}
