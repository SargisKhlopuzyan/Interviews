package com.example.presenter.ui.services

import androidx.lifecycle.ViewModel

class ServicesViewModel : ViewModel() {
    fun onEvent(event: ServicesUiEvent) {
        when (event) {
            is ServicesUiEvent.OnStartServiceClicked -> {

            }
            ServicesUiEvent.OnStopServiceClicked -> {

            }
            ServicesUiEvent.OnBindServiceClicked -> {

            }
            ServicesUiEvent.OnUnbindServiceClicked -> {

            }
        }
    }
}