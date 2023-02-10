package com.example.presenter.ui.services

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.presenter.services.MyService
import com.example.presenter.ui.theme.InterviewTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class ServicesFragment : Fragment() {

    private val viewModel: ServicesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                InterviewTheme {
                    ServicesScreen(
                        onStartServiceClicked = {
                            startService()
                            viewModel.onEvent(ServicesUiEvent.OnStartServiceClicked)
                        },
                        onStopServiceClicked = {
                            stopService()
                            viewModel.onEvent(ServicesUiEvent.OnStopServiceClicked)
                        },
                        onBindServiceClicked = {
                            bindService()
                            viewModel.onEvent(ServicesUiEvent.OnBindServiceClicked)
                        },
                        onUnbindServiceClicked = {
                            unbindService()
                            viewModel.onEvent(ServicesUiEvent.OnUnbindServiceClicked)
                        }
                    )
                }
            }
        }
    }

    private fun startService() {
        val serviceIntent = Intent(requireActivity(), MyService::class.java)
        requireActivity().startService(serviceIntent)
    }

    private fun stopService() {

    }

    private fun bindService() {}

    private fun unbindService() {}

}