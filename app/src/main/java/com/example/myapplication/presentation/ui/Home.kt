package com.example.myapplication.presentation.ui

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
import com.example.myapplication.presentation.HomeViewModel
import com.example.myapplication.presentation.ui.home.CurrentDayWeatherInfo
import com.example.myapplication.presentation.ui.home.DailyForecastCard
import com.example.myapplication.presentation.ui.home.HourlyForecastCard
import com.example.myapplication.domain.base.Result
import com.example.myapplication.domain.base.data
import com.example.myapplication.presentation.ui.components.ErrorMessage
import com.example.myapplication.presentation.ui.home.WeatherDetailsCard
import com.fidloo.flux.presentation.ui.component.SectionProgressBar
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun WeatherScreen(viewModel: HomeViewModel){
    val viewState by viewModel.state.collectAsState()
    val refreshState = rememberSwipeRefreshState(isRefreshing = viewState.isRefreshing)

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
                viewState.currentWeather,
            )

            /*TODO: Хотелось бы так же вынести весь этот однотипный код, чтобы через одну команду запускать
            *  Потребуется посмотреть дженерики*/
            when (viewState.weeklyWeather) {
                is Result.Error -> ErrorMessage()
                Result.Loading -> SectionProgressBar()
                is Result.Success ->
                    HourlyForecastCard(
                        Modifier.fillMaxWidth(),
                        /*TODO: Выглядит очень некрасиво, надо подумать над этим*/
                        viewState.hourlyWeather.data
                    )
            }


            Divider(color = Color.White, thickness = 1.dp)
            when (viewState.weeklyWeather) {
                is Result.Error -> ErrorMessage()
                Result.Loading -> SectionProgressBar()
                is Result.Success -> DailyForecastCard(
                    Modifier.fillMaxWidth(),
                    /*TODO: Выглядит очень некрасиво, надо подумать над этим*/
                    viewState.weeklyWeather.data
                )
            }
            WeatherDetailsCard(Modifier.fillMaxWidth())
            ErrorMessage()
        }
    }
}
