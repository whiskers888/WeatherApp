package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.CurrentlyWeather
import com.example.myapplication.domain.model.DailyWeather
import com.example.myapplication.domain.model.HourlyWeather


interface WeatherRepository {
    suspend fun fetchCurrentWeather(): CurrentlyWeather
    suspend fun fetchDailyWeather(): List<HourlyWeather>
    suspend fun fetchWeeklyWeather(): List<DailyWeather>
}