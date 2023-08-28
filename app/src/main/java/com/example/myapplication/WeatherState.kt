package com.example.myapplication

import com.example.myapplication.models.WeatherType

data class WeatherState(
    val isRefreshing: Boolean,
    val weatherType: WeatherType,
)

