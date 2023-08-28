package com.example.myapplication.ui.utils

import com.example.myapplication.R
import com.example.myapplication.constants.StringConstants
import com.example.myapplication.models.WeatherType

object WeatherStateConstants{
        //WeatherType
        const val SUNNY = "Ясно"
        const val RAINY = "Дождь"
        const val STORMY = "Гроза"
        const val CLOUDY = "Облачно"
}

fun WeatherType.getDescriptionRes(): String {
    return when (this) {
        WeatherType.SUNNY -> WeatherStateConstants.SUNNY
        WeatherType.RAINY -> WeatherStateConstants.RAINY
        WeatherType.STORMY -> WeatherStateConstants.STORMY
        WeatherType.CLOUDY -> WeatherStateConstants.CLOUDY
    }
}

fun WeatherType.getIconRes(nightMode: Boolean = false): Int {
    return when (this) {
        WeatherType.SUNNY -> if (nightMode) throw Exception("Pizdec") else R.drawable.ic_sunny
        WeatherType.RAINY -> if (nightMode) throw Exception("Pizdec") else R.drawable.ic_rainy
        WeatherType.STORMY -> if (nightMode) throw Exception("Pizdec") else R.drawable.ic_stormy
        WeatherType.CLOUDY -> if (nightMode) throw Exception("Pizdec") else R.drawable.ic_cloudy
    }
}