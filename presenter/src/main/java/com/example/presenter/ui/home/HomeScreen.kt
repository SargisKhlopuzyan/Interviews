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
    onStartJobScheduleClicked: () -> Unit,
    onStartJobIntentServiceClicked: () -> Unit,
    onNavigateServiceScreenClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            onStartJobScheduleClicked()
        }) {
            Text(
                text = stringResource(id = R.string.start_job_scheduler)
            )
        }
        Button(onClick = {
            onStartJobIntentServiceClicked()
        }) {
            Text(
                text = stringResource(id = R.string.start_job_intent_service)
            )
        }
        Button(onClick = {
            onNavigateServiceScreenClicked()
        }) {
            Text(
                text = stringResource(id = R.string.navigate_music_list_screen)
            )
        }
    }
}