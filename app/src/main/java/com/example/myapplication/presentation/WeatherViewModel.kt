package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.business.FetchCurrentWeather
import com.example.myapplication.domain.business.FetchDailyWeather
import com.example.myapplication.domain.business.FetchWeeklyWeather
import com.example.myapplication.domain.model.WeatherState
import com.example.myapplication.domain.model.WeatherType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val fetchCurrentWeather: FetchCurrentWeather,
    private val fetchDailyWeather: FetchDailyWeather,
    private val fetchWeekWeather: FetchWeeklyWeather,
) : ViewModel(
) {
    private val _weatherState =
        MutableStateFlow(WeatherState(isRefreshing = false, weatherType = WeatherType.SUNNY))
    val weatherState: StateFlow<WeatherState> = _weatherState

    fun refresh() {
        val currentType = _weatherState.value.weatherType
        _weatherState.value = _weatherState.value.copy(isRefreshing = true)
        viewModelScope.launch {
            delay(2000)
            _weatherState.value = WeatherState(
                isRefreshing = false,
                weatherType =
                when (currentType) {
                    WeatherType.SUNNY -> WeatherType.RAINY
                    WeatherType.RAINY -> WeatherType.CLOUDY
                    WeatherType.CLOUDY -> WeatherType.STORMY
                    WeatherType.STORMY -> WeatherType.SUNNY
                },
            )
        }
    }
}