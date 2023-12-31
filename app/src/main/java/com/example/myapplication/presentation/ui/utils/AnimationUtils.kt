package com.example.myapplication.presentation.ui.utils

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Color.animated(
    animationSpec: AnimationSpec<Color> = spring(stiffness = Spring.StiffnessMediumLow),
    finishedListener: ((Color) -> Unit)? = null,
) = animateColorAsState(
    targetValue = this,
    animationSpec = animationSpec,
    finishedListener = finishedListener, label = "",
).value