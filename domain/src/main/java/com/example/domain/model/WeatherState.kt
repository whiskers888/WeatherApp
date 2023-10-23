package com.example.myapplication.domain.model

import com.example.myapplication.domain.model.WeatherType

data class WeatherState(
    val isRefreshing: Boolean,
    val weatherType: WeatherType,
)

