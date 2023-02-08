package com.example.presenter.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

//@ExperimentalCoroutinesApi
class HomeViewModel : ViewModel() {

    fun onEvent(event: HomeUiEvent) {
        when(event) {
            HomeUiEvent.OnServiceClicked -> {

            }
        }
    }
}