package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _states = MutableStateFlow(State(emptyList()))
    val states = _states.asStateFlow()

    init {
        viewModelScope.launch {
            repeat(Int.MAX_VALUE) { n ->
                delay(5000)
                val state = _states.value
                _states.value = state.copy(userMessages = state.userMessages + n.toString())
            }
        }
    }

    fun showedUserMessage(message: String) {
        val state = _states.value
        _states.value = state.copy(userMessages = state.userMessages.filter { it != message })
    }
}

data class State(val userMessages: List<String>)
