package com.example.presenter.ui.base

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    protected fun NavDirections.navigate(navController: NavController = findNavController()) {
        try {
            navController.navigate(this)
        } catch (t: Throwable) {

        }
    }
}