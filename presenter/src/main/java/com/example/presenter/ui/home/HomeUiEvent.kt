package com.example.presenter.ui.home

sealed interface HomeUiEvent {
    object OnServiceClicked : HomeUiEvent
}