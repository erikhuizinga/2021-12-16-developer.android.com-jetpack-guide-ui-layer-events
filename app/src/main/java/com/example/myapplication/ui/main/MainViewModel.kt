package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _states = MutableStateFlow(State(false))
    val states = _states.asStateFlow()

    fun navigate() {
        _states.value = _states.value.copy(navigateToSecondary = true)
    }

    fun navigated() {
        _states.value = _states.value.copy(navigateToSecondary = false)
    }
}

data class State(val navigateToSecondary: Boolean)
