package com.example.presenter.ui.music.detail

sealed interface MusicDetailUiEvent {
    object OnStartClicked : MusicDetailUiEvent
    object OnStopClicked : MusicDetailUiEvent
}