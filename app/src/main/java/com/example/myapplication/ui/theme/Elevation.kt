package com.fidloo.flux.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Elevation values that can be themed.
 */
@Immutable
data class Elevations(
    val Backdrop: Dp = 8.dp,
    val Card: Dp = 4.dp,
)

internal val LocalElevations = staticCompositionLocalOf { Elevations() }
