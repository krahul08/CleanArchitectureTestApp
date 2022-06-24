package com.rahul.cleanarchitecturetestapp.presentation

sealed class Screens(val route: String) {

    object CoinListScreen : Screens("coin_list_screen")
    object CoinDetailsScreen : Screens("coin_details_screen")
}
