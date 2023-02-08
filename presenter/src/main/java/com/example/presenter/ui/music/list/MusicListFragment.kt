package com.example.presenter.ui.music.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.presenter.ui.theme.InterviewTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MusicListFragment : Fragment() {

    private val viewModel: MusicListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                InterviewTheme {
                    MusicListScreen(
                        viewModel = viewModel,
                        onNavigateServiceScreenClicked = {
//                            navigateToSongDetailScreen()
                        }
                    )
                }
            }
        }
    }
}