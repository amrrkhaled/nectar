package com.example.nectar.ui.screens.explore

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nectar.domain.usecase.cartItems.AddToCartUseCase
import com.example.nectar.domain.usecase.explore.GetProductsByCategoryUseCase
import com.example.nectar.domain.usecase.explore.SearchProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ExploreHomeSharedViewModel @Inject constructor(

) : ViewModel() {


    private val _searchBarFocus = MutableStateFlow(false)
    val searchBarFocus: StateFlow<Boolean> = _searchBarFocus

    fun triggerSearchFocus() {
         Log.d("ExploreHomeSharedViewModel", "Search bar focus triggered")
        _searchBarFocus.value = true
    }

    fun consumeSearchFocus() {
            Log.d("ExploreHomeSharedViewModel", "Search bar focus consumed")
        _searchBarFocus.value = false
    }
}