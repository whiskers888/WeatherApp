package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.WeatherRepositoryImpl
import com.example.myapplication.domain.base.successOr
import com.example.myapplication.domain.business.FetchCurrentWeather
import com.example.myapplication.domain.business.FetchDailyWeather
import com.example.myapplication.domain.business.FetchWeeklyWeather
import com.example.myapplication.domain.model.CurrentlyWeather.Companion.getDefault
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val fetchCurrentWeather: FetchCurrentWeather = FetchCurrentWeather(WeatherRepositoryImpl(), Dispatchers.IO),
    private val fetchDailyWeather: FetchDailyWeather= FetchDailyWeather(WeatherRepositoryImpl(), Dispatchers.IO),
    private val fetchWeekWeather: FetchWeeklyWeather= FetchWeeklyWeather(WeatherRepositoryImpl(), Dispatchers.IO),
) : ViewModel(
) {
    private val _state =
        MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState> = _state

    private var job: Job? = null;

    private val _particleAnimationIteration = MutableStateFlow(0L)
    val particleAnimationIteration: StateFlow<Long> = _particleAnimationIteration


    init {
        loadData()
        viewModelScope.launch(Dispatchers.Default) {
            while (true) {
                _particleAnimationIteration.value++
                delay(10000L)
            }
        }
    }

    private fun loadData(userAction:Boolean = false){
        job = viewModelScope.launch {
            combine(
                fetchCurrentWeather(Unit),
                fetchDailyWeather(Unit),
                fetchWeekWeather(Unit)
            ){currentWeather, hourlyWeather, weekWeather ->

                // Нужно предотвратить обновление с помощью свайпа, чтобы заменить успешное состояние индикатором выполнения
                val newCurrentWeather = currentWeather.successOr(getDefault())

                val newHourlyWeather = if (hourlyWeather.isSuccessful()) {
                    hourlyWeather
                } else {
                    state.value.hourlyWeather
                }

                val newWeekWeather = if (!userAction || weekWeather.isSuccessful()) {
                    weekWeather
                } else {
                    state.value.weeklyWeather
                }

                state.value.copy(
                    currentWeather = newCurrentWeather,
                    hourlyWeather = newHourlyWeather,
                    weeklyWeather = newWeekWeather,
                    isRefreshing = if (userAction) {
                        currentWeather.isLoading() || hourlyWeather.isLoading() || weekWeather.isLoading()
                    } else {
                        false
                    }
                )
            }.collect { _state.value = it }
        }    }
    fun refresh() {
        job?.cancel()
        _state.value = state.value.copy(isRefreshing = true)
        loadData(true)
    }
}