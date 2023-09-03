package com.example.myapplication.domain.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


object DispatchersModule {

    @DefaultDispatcher
    @JvmStatic
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @JvmStatic
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @JvmStatic
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}