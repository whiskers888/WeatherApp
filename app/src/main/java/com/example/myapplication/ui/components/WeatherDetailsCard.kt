package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.shapes
import com.example.myapplication.ui.utils.animated

data class WeatherDetails(
    val type: String,
    val value: String
)

val sampleWeatherDetails = listOf(
    WeatherDetails("Ветер", "33 м/ч"),
    WeatherDetails("Влажность", "23%"),
    WeatherDetails("Видимость", "11 км"),
    /*WeatherDetails("Давление", "754 мм рт. ст."),
    WeatherDetails("Ощущается", "18 ${StringConstants.DEGREE}"),*/
)
@Composable
fun WeatherDetailsCard(modifier:Modifier) {
    Surface(
        modifier,
        color = MaterialTheme.colors.surface.animated(),
        shape = shapes.medium
    ){
        Row (
            modifier
                /*TODO: Потребуется установить цвет для Row, чтобы потом Column разделить по цветам.
                *  но возможно если сделать нормальный компонент, оно все само починится*/
                /*.background(MaterialTheme.colors.secondary)*/
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            sampleWeatherDetails.forEach { (type, value)->
                Column{
                    Text(text = type, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.size(8.dp))
                    Text(text = value)
                }
            }
        }
    }
}