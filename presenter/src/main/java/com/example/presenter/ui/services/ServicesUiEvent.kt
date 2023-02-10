package com.example.presenter.ui.services

sealed interface ServicesUiEvent {
    object OnStartServiceClicked : ServicesUiEvent
    object OnStopServiceClicked : ServicesUiEvent
    object OnBindServiceClicked : ServicesUiEvent
    object OnUnbindServiceClicked : ServicesUiEvent
}