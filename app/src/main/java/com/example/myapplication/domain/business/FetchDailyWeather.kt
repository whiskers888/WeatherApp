package com.example.myapplication.domain.business

import com.example.myapplication.domain.base.FlowUseCase
import com.example.myapplication.domain.base.Result
import com.example.myapplication.domain.model.HourlyWeather
import com.example.myapplication.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FetchDailyWeather(private val repository: WeatherRepository, dispatcher: CoroutineDispatcher) : FlowUseCase<Unit, List<HourlyWeather>>(
    dispatcher
) {
    override fun execute(parameters: Unit): Flow<Result<List<HourlyWeather>>> {
        return flow {
            emit(Result.Loading)
            emit(Result.Success(repository.fetchDailyWeather()))
        }
    }
}