package com.example.interview.ui.music

sealed interface MusicUiEvent {
    object OnStartClicked : MusicUiEvent
    object OnStopClicked : MusicUiEvent
}