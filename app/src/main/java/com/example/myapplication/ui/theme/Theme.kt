package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.myapplication.R
import com.example.myapplication.models.WeatherType
import com.fidloo.flux.presentation.ui.theme.Elevations
import com.fidloo.flux.presentation.ui.theme.LocalElevations

private val LightTheme = lightColors(
    primary = yellow500,
    secondary = rust600,
    onSecondary = white,
    onPrimary = white,
    surface = blue,
    background = whiteBlue,
    onSurface = white
)

private val DarkTheme = darkColors(
    primary = yellow,
    secondary = rust300,
    onSecondary = gray900,
    onPrimary = gray900,
    surface = white150,
    background = gray900,
    onSurface = white800
)

private val LightImages = Images(lockupLogo = R.drawable.ic_sunny)

private val DarkImages = Images(lockupLogo = R.drawable.ic_night_clear)

@Composable
fun MyApplicationTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkTheme
    } else {
        LightTheme
    }

    val images = if (darkTheme) DarkImages else LightImages
    CompositionLocalProvider(
        LocalElevations provides Elevations(),
        LocalImages provides images
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}