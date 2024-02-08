package com.jass.weather.screens.home

sealed class HomeState {
    data object Loading : HomeState()
    data object Success : HomeState()
    data object Error : HomeState()
}