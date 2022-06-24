package com.rahul.cleanarchitecturetestapp.presentation.coin_list

import com.rahul.cleanarchitecturetestapp.domain.model.Coin

data class CoinListState(

    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)
