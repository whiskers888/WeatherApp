package com.example.myapplication.presentation.ui.home

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.model.CurrentlyWeather
import com.example.myapplication.presentation.constants.StringConstants
import com.example.myapplication.presentation.ui.utils.getDescriptionRes
import com.example.myapplication.presentation.ui.utils.getIconRes

@Composable
fun CurrentDayWeatherInfo (
    modifier:Modifier,
    currentDayWeatherInfo: CurrentlyWeather
){
    Column(
        modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Crossfade(
            targetState = currentDayWeatherInfo,
            animationSpec = spring(stiffness = Spring.StiffnessMediumLow), label = ""
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ){
                Icon(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(it.weatherType.getIconRes()),
                    contentDescription = StringConstants.CURRENTWEATHER,
                    tint = Color.White,
                )
                Text(
                    text = it.weatherType.getDescriptionRes(),
                    color = Color.White,
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
        Spacer(Modifier.size(10.dp))
        Text(
            text = "25${StringConstants.DEGREE}",
            color = Color.White,
            style = MaterialTheme.typography.h1
        )
    }
}