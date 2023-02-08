package com.example.presenter.ui.music.list

import com.example.domain.entity.Music

sealed interface MusicListUiEvent {
    data class OnMusicClicked(val music: Music) : MusicListUiEvent
}