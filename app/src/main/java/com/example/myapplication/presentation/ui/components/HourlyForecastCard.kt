package com.example.myapplication.presentation.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.model.HourlyWeather
import com.example.myapplication.presentation.constants.StringConstants
import com.example.myapplication.domain.model.WeatherType
import com.example.myapplication.presentation.ui.utils.animated
import com.example.myapplication.presentation.ui.utils.getIconRes


@Composable
fun HourlyForecastCard (modifier:Modifier){
    Surface(
        modifier,
        color = MaterialTheme.colors.surface.animated(),
        shape = MaterialTheme.shapes.medium
    ){
        Column(modifier.padding(15.dp)){
            Text(text = "Погода по часам", fontWeight = FontWeight.Bold)
            Spacer(modifier.size(20.dp))
            Row(
                modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ){

                /*TODO: из ViewModel потребуется достать данные и отобразить здесь*/
                /*sampleHourlyData.forEach {
                    HourlyForecastItem(it)
                }*/
            }
        }

    }
}

@Composable
fun HourlyForecastItem (data: HourlyWeather){
    val (type, time, wind, temperature) = data
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /* TODO: Тут потребуется вытаскивать текущее время и сравнивать его с тем которое передано
            Если совпало то писать "Сейчас"*/
        /* val currentHourly = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("hh"))*/

        Text(text = if (time == 6) "Сейчас" else "$time:00 ")
        Icon(painter = painterResource(
            type.getIconRes()
        ),
        contentDescription = "Погода по часам")

        Text(text = "$temperature${StringConstants.DEGREE}")

        Text(text = "$wind м/c")
    }
}