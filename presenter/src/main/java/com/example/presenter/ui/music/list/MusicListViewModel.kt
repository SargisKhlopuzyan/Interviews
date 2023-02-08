package com.example.presenter.ui.music.list

import androidx.lifecycle.ViewModel

class MusicListViewModel : ViewModel() {

    fun onEvent(event: MusicListUiEvent) {
        when (event) {
            is MusicListUiEvent.OnMusicClicked -> {

            }
        }
    }
}