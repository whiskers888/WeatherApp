package com.example.myapplication.domain.business

import com.example.myapplication.domain.base.FlowUseCase
import com.example.myapplication.domain.base.Result
import com.example.myapplication.domain.model.DailyWeather
import com.example.myapplication.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchWeeklyWeather(private val repository: WeatherRepository, dispatcher: CoroutineDispatcher) : FlowUseCase<Unit, List<DailyWeather>>(
    dispatcher
) {
    override fun execute(parameters: Unit): Flow<Result<List<DailyWeather>>> {
        return flow {
            emit(Result.Loading)
            emit(Result.Success(repository.fetchWeeklyWeather()))
        }
    }
}