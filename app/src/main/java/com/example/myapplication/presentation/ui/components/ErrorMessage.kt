package com.example.myapplication.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ErrorMessage(message: String = "An error occurred.") {
    Text(
        text = message,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
    )
}

@Preview
@Composable
fun GenericErrorMessagePreview() {
    ErrorMessage()
}