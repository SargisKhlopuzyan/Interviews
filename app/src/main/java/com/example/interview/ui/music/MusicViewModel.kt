package com.example.interview.ui.music

import androidx.lifecycle.ViewModel

class MusicViewModel : ViewModel() {

    fun onEvent(event: MusicUiEvent) {
        when(event) {
            MusicUiEvent.OnStartClicked -> {

            }
            MusicUiEvent.OnStopClicked -> {

            }
        }
    }
}