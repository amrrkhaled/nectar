//package com.example.nectar.ui.screens.onboarding
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.nectar.domain.usecase.SetOnboardingCompleted
//import kotlinx.coroutines.launch
//import javax.inject.Inject//
//class OnboardingViewModel @Inject constructor(
//    private val setOnboardingCompleted: SetOnboardingCompleted
//) : ViewModel() {
//
//    fun completeOnboarding() {
//        viewModelScope.launch {
//            setOnboardingCompleted()
//        }
//    }
//}