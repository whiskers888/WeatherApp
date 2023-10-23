package com.example.myapplication.domain.model
import java.util.Date

data class DailyWeather (
    val weatherType: WeatherType,
    val weekDay: String,
    val date: String,
    val maxTemp: Int,
    val minTemp: Int
){
    companion object{
        fun getDefault(): List<DailyWeather> {
            return listOf(
                DailyWeather(
                    weatherType = WeatherType.SUNNY,
                    weekDay = "Сегодня",
                    date = "Авг 26",
                    maxTemp = 32,
                    minTemp = 18
                ),
                DailyWeather(
                    weatherType = WeatherType.CLOUDY,
                    weekDay = "Вс",
                    date = "Авг 27",
                    maxTemp = 26,
                    minTemp = 16
                ),
                DailyWeather(
                    weatherType = WeatherType.RAINY,
                    weekDay = "Пн",
                    date = "Авг 28",
                    maxTemp = 24,
                    minTemp = 13
                ),
                DailyWeather(
                    weatherType = WeatherType.SUNNY,
                    weekDay = "Вт",
                    date = "Авг 29",
                    maxTemp = 30,
                    minTemp = 16
                ),
                DailyWeather(
                    weatherType = WeatherType.SUNNY,
                    weekDay = "Ср",
                    date = "Авг 30",
                    maxTemp = 30,
                    minTemp = 15
                ),
                DailyWeather(
                    weatherType = WeatherType.CLOUDY,
                    weekDay = "Чт",
                    date = "Авг 31",
                    maxTemp = 27,
                    minTemp = 17
                ),
                DailyWeather(
                    weatherType = WeatherType.STORMY,
                    weekDay = "Пт",
                    date = "Сен 1",
                    maxTemp = 22,
                    minTemp = 13
                ),
            )
        }
    }
}