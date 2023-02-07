package com.example.interview.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    fun onEvent(event: HomeUiEvent) {
        when(event) {
            HomeUiEvent.OnServiceClicked -> {

            }
        }
    }
}