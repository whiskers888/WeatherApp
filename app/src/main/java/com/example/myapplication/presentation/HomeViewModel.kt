package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.base.successOr
import com.example.myapplication.domain.business.FetchCurrentWeather
import com.example.myapplication.domain.business.FetchDailyWeather
import com.example.myapplication.domain.business.FetchWeeklyWeather
import com.example.myapplication.domain.model.CurrentlyWeather.Companion.getDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchCurrentWeather: FetchCurrentWeather,
    private val fetchDailyWeather: FetchDailyWeather,
    private val fetchWeekWeather: FetchWeeklyWeather,
) : ViewModel()  {
    private val _state =
        MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState> = _state

    private var job: Job? = null;

    init {
        loadData()
        viewModelScope.launch(Dispatchers.Default) {
            while (true) {
                delay(100)
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