package com.example.myapplication.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.domain.model.DailyWeather
import com.example.myapplication.presentation.constants.StringConstants
import com.example.myapplication.domain.model.WeatherType
import com.example.myapplication.presentation.ui.utils.animated

@Composable
fun DailyForecastCard (modifier: Modifier, weeklyWeatherData: List<DailyWeather>?) {
    Surface(
        modifier,
        color = MaterialTheme.colors.surface.animated(),
        shape = MaterialTheme.shapes.medium
    ){
        Column(
            modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Text(text = "Прогноз на неделю", fontWeight = FontWeight.Medium)
            weeklyWeatherData?.forEach {
                DailyForecastItem(modifier = modifier.fillMaxWidth(), data = it)
            }
        }
    }
}

@Composable
fun DailyForecastItem(modifier: Modifier, data: DailyWeather){
    val( type, weekDay, date, maxT, minT) = data
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier.weight(1f),
            text = "$weekDay, $date")
        Text(
            modifier = Modifier.weight(1f),
            text = buildAnnotatedString{
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                    append("$maxT${StringConstants.DEGREE}")
                }

                withStyle(SpanStyle(fontWeight = FontWeight.ExtraLight)){
                    append(" / ")
                }

                withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                    append("$minT${StringConstants.DEGREE}")
                }
            },
            textAlign = TextAlign.Justify
        )
        Icon(
            modifier = Modifier.weight(1f,false),
            painter = painterResource(
                when(type){
                    WeatherType.RAINY -> R.drawable.ic_rainy
                    WeatherType.SUNNY -> R.drawable.ic_sunny
                    WeatherType.CLOUDY -> R.drawable.ic_cloudy
                    WeatherType.STORMY -> R.drawable.ic_stormy
                }
            ),
            contentDescription = "Погода на 7 дней"
        )
    }
}