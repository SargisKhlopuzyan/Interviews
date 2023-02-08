package com.example.presenter.ui.music.detail

import androidx.lifecycle.ViewModel

class MusicDetailViewModel : ViewModel() {

    fun onEvent(event: MusicDetailUiEvent) {
        when(event) {
            MusicDetailUiEvent.OnStartClicked -> {

            }
            MusicDetailUiEvent.OnStopClicked -> {

            }
        }
    }
}