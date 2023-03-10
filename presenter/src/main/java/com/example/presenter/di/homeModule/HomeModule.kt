package com.example.presenter.di.homeModule

import com.example.presenter.ui.home.HomeViewModel
import com.example.presenter.ui.music.list.MusicListViewModel
import com.example.presenter.ui.services.ServicesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presenterModule = module {
    viewModel {
        HomeViewModel()
    }

    viewModel {
        MusicListViewModel()
    }

    viewModel {
        ServicesViewModel()
    }
}