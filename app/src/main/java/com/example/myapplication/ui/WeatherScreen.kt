package com.example.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.WeatherViewModel
import com.example.myapplication.ui.components.CurrentDayWeatherInfo
import com.example.myapplication.ui.components.DailyForecastCard
import com.example.myapplication.ui.components.HourlyForecastCard
import com.example.myapplication.ui.components.WeatherDetailsCard
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun WeatherScreen(viewModel:WeatherViewModel){
    val state by viewModel.weatherState.collectAsState()
    val refreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)

    SwipeRefresh(state = refreshState, onRefresh = viewModel::refresh) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    rememberInsetsPaddingValues(
                        insets = LocalWindowInsets.current.systemBars
                    )
                )
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CurrentDayWeatherInfo(
                Modifier.fillMaxWidth(),
                state.weatherType,
            )
            Divider(color = Color.White, thickness = 1.dp)
            HourlyForecastCard(Modifier.fillMaxWidth())
            DailyForecastCard(Modifier.fillMaxWidth())

            WeatherDetailsCard(Modifier.fillMaxWidth())
        }
        
    }
}