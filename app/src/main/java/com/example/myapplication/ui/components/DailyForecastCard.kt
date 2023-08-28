package com.example.myapplication.ui.components

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
import com.example.myapplication.constants.StringConstants
import com.example.myapplication.models.WeatherType
import com.example.myapplication.ui.utils.animated

data class DailyForecastData(
    val weatherType: WeatherType,
    val weekDay: String,
    val date: String,
    val maxTemp: Int,
    val minTemp: Int
)

val fakeSampleDailyForecastData = listOf(
    DailyForecastData(
        weatherType = WeatherType.SUNNY,
        weekDay = "Сегодня",
        date = "Авг 26",
        maxTemp = 32,
        minTemp = 18
    ),
    DailyForecastData(
        weatherType = WeatherType.CLOUDY,
        weekDay = "Вс",
        date = "Авг 27",
        maxTemp = 26,
        minTemp = 16
    ),
    DailyForecastData(
        weatherType = WeatherType.RAINY,
        weekDay = "Пн",
        date = "Авг 28",
        maxTemp = 24,
        minTemp = 13
    ),
    DailyForecastData(
        weatherType = WeatherType.SUNNY,
        weekDay = "Вт",
        date = "Авг 29",
        maxTemp = 30,
        minTemp = 16
    ),
    DailyForecastData(
        weatherType = WeatherType.SUNNY,
        weekDay = "Ср",
        date = "Авг 30",
        maxTemp = 30,
        minTemp = 15
    ),
    DailyForecastData(
        weatherType = WeatherType.CLOUDY,
        weekDay = "Чт",
        date = "Авг 31",
        maxTemp = 27,
        minTemp = 17
    ),
    DailyForecastData(
        weatherType = WeatherType.STORMY,
        weekDay = "Пт",
        date = "Сен 1",
        maxTemp = 22,
        minTemp = 13
    ),
)

@Composable
fun DailyForecastCard (modifier: Modifier) {
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
            fakeSampleDailyForecastData.forEach {
                DailyForecastItem(modifier.fillMaxWidth(), it)
            }
        }
    }
}

@Composable
fun DailyForecastItem(modifier: Modifier, data:DailyForecastData){
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