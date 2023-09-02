package com.example.myapplication.presentation.ui.utils

import com.example.myapplication.R
import com.example.myapplication.domain.model.WeatherTypeConstants
import com.example.myapplication.domain.model.WeatherType


fun WeatherType.getDescriptionRes(): String {
    return when (this) {
        WeatherType.SUNNY -> WeatherTypeConstants.SUNNY
        WeatherType.RAINY -> WeatherTypeConstants.RAINY
        WeatherType.STORMY -> WeatherTypeConstants.STORMY
        WeatherType.CLOUDY -> WeatherTypeConstants.CLOUDY
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