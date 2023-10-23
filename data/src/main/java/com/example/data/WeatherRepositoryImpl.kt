package com.example.data

import com.example.myapplication.domain.model.CurrentlyWeather
import com.example.myapplication.domain.model.DailyWeather
import com.example.myapplication.domain.model.HourlyWeather
import com.example.myapplication.domain.repository.WeatherRepository
import java.util.Date
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor() : WeatherRepository {
    override suspend fun fetchCurrentWeather(): CurrentlyWeather {
        return WeatherDataSource.fetchCurrentWeather()
    }

    override suspend fun fetchDailyWeather(): List<HourlyWeather> {
        return WeatherDataSource.getNext24HoursWeather()
    }

    override suspend fun fetchWeeklyWeather(): List<DailyWeather> {
        return WeatherDataSource.getNext7dayWeather()
    }
}