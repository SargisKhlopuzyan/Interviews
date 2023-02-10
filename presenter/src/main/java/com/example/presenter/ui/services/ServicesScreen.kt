package com.example.presenter.ui.services

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.presenter.R

@Composable
fun ServicesScreen(
    onStartServiceClicked: () -> Unit,
    onStopServiceClicked: () -> Unit,
    onBindServiceClicked: () -> Unit,
    onUnbindServiceClicked: () -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Button(onClick = {
                onStartServiceClicked()
            }) {
                Text(
                    text = stringResource(id = R.string.start_service)
                )
            }
        }

        item {
            Button(onClick = {
                onStopServiceClicked()
            }) {
                Text(
                    text = stringResource(id = R.string.stop_service)
                )
            }
        }

        item {
            Button(onClick = {
                onBindServiceClicked()
            }) {
                Text(
                    text = stringResource(id = R.string.bind_service)
                )
            }
        }

        item {
            Button(onClick = {
                onUnbindServiceClicked()
            }) {
                Text(
                    text = stringResource(id = R.string.unbind_service)
                )
            }
        }
    }

}