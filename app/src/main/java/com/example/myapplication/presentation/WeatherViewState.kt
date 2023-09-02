package com.example.myapplication.presentation

import com.example.myapplication.domain.model.CurrentlyWeather
import com.example.myapplication.domain.model.HourlyWeather
import com.example.myapplication.domain.base.Result
import com.example.myapplication.domain.model.DailyWeather

data class HomeViewState(
    val currentWeather: CurrentlyWeather = CurrentlyWeather.getDefault(),
    val hourlyWeather: Result<List<HourlyWeather>> = Result.Loading,
    val weekWeather: Result<List<DailyWeather>> = Result.Loading,
    val refreshing: Boolean = false
)