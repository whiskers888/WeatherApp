package com.example.myapplication.presentation

import com.example.myapplication.domain.model.CurrentlyWeather
import com.example.myapplication.domain.model.HourlyWeather
import com.example.myapplication.domain.base.Result
import com.example.myapplication.domain.model.DailyWeather

data class HomeViewState(
    val currentWeather: CurrentlyWeather = CurrentlyWeather.getDefault(),
    val hourlyWeather: Result<List<HourlyWeather>> = Result.Error(Throwable()),
    val weeklyWeather: Result<List<DailyWeather>> = Result.Error(Throwable()),
    val isRefreshing: Boolean = false
)