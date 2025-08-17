package com.example.nectar.ui.navigation

import androidx.lifecycle.ViewModel
import com.example.nectar.data.prefrences.OnboardingPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavHostViewModel @Inject constructor(
    val onboardingPreferences: OnboardingPreferences
): ViewModel()
