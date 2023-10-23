package com.example.data

import com.example.myapplication.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module()
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideWeatherRepository(repository: WeatherRepositoryImpl):WeatherRepository
}