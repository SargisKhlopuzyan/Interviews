package com.example.interview.di.homeModule

import com.example.interview.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel {
        HomeViewModel()
    }
}