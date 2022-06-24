package com.rahul.cleanarchitecturetestapp.presentation.coin_details

import com.rahul.cleanarchitecturetestapp.domain.model.CoinDetails

data class CoinDetailsState(

    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""

)
