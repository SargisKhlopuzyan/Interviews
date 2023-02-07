package com.example.interview.ui.home

sealed interface HomeUiEvent {
    object OnServiceClicked : HomeUiEvent
}