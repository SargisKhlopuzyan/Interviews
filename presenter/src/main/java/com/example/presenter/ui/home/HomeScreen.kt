package com.example.presenter.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.presenter.R

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigateServiceScreenClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onNavigateServiceScreenClicked()
            }) {
            Text(text = stringResource(id = R.string.navigate_music_list_screen))
        }
    }
}