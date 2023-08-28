package com.example.myapplication.ui.components

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
import com.example.myapplication.R
import com.example.myapplication.constants.StringConstants
import com.example.myapplication.models.WeatherType
import com.example.myapplication.ui.utils.animated

data class HourlyForecastData(
    val weatherType: WeatherType,
    val time: Int,
    val wind: Int,
    val temperature: Int
)

val sampleHourlyData = listOf(
    HourlyForecastData(
        WeatherType.SUNNY,
        6,
        21,
        16
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        7,
        21,
        19
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        8,
        20,
        21
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        9,
        20,
        24
    ),
    HourlyForecastData(
        WeatherType.RAINY,
        10,
        21,
        25
    ),
    HourlyForecastData(
        WeatherType.RAINY,
        11,
        21,
        28
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        12,
        19,
        30
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        13,
        16,
        31
    ),
    HourlyForecastData(
        WeatherType.SUNNY,
        14,
        16,
        30
    ),
    HourlyForecastData(
        WeatherType.STORMY,
        15,
        16,
        30
    ),
    HourlyForecastData(
        WeatherType.STORMY,
        16,
        17,
        32
    ),
    HourlyForecastData(
        WeatherType.STORMY,
        17,
        19,
        29
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        18,
        19,
        27
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        19,
        20,
        24
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        20,
        21,
        23
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        21,
        21,
        20
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        22,
        22,
        19
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        23,
        19,
        20
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        0,
        19,
        18
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        1,
        21,
        16
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        2,
        20,
        16
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        3,
        24,
        14
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        4,
        28,
        13
    ),
    HourlyForecastData(
        WeatherType.CLOUDY,
        5,
        23,
        14
    )
)


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
                sampleHourlyData.forEach {
                    HourlyForecastItem(it)
                }
            }
        }

    }
}

@Composable
fun HourlyForecastItem (data:HourlyForecastData){
    val (type, time, wind, temperature) = data
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /* TODO: Тут потребуется вытаскивать текущее время и сравнивать его с тем которое передано
            Если совпало то писать "Сейчас"*/
        val currentHourly = /*LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("hh"))*/

        Text(text = if (time == 6) "Сейчас" else "$time:00 ")
        Icon(painter = painterResource(
            when(type) {
                WeatherType.CLOUDY -> R.drawable.ic_cloudy
                WeatherType.STORMY -> R.drawable.ic_stormy
                WeatherType.SUNNY -> R.drawable.ic_sunny
                WeatherType.RAINY -> R.drawable.ic_rainy
            }
        ),
        contentDescription = "Погода по часам")

        Text(text = "$temperature${StringConstants.DEGREE}")

        Text(text = "$wind м/c")
    }
}