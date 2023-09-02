package com.example.myapplication.domain.model
enum class WeatherType {
    SUNNY,
    RAINY,
    CLOUDY,
    STORMY
}

object WeatherTypeConstants{
    const val SUNNY = "Ясно"
    const val RAINY = "Дождь"
    const val STORMY = "Гроза"
    const val CLOUDY = "Облачно"
}