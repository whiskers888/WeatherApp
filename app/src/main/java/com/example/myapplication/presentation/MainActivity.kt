package com.example.myapplication.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.view.WindowCompat
import androidx.compose.runtime.Composable
import com.example.myapplication.R
import com.example.myapplication.presentation.ui.WeatherScreen
import com.example.myapplication.presentation.ui.theme.MyApplicationTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MyApplication)
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MyApplicationTheme() {
                ProvideWindowInsets {

                    BarsTheming(window)
                    MyApp(viewModel)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: WeatherViewModel) {
    Surface(color = MaterialTheme.colors.background) {
        WeatherScreen(viewModel = viewModel)
    }
}

@Composable
fun BarsTheming(window: Window) {
    window.statusBarColor = Color.TRANSPARENT
    window.navigationBarColor = Color.TRANSPARENT
}