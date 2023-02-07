package com.example.interview.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.interview.R
import com.example.interview.ui.home.HomeViewModel

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
            Text(text = stringResource(id = R.string.navigate_service_screen))
        }
    }
}