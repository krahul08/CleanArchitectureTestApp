package com.rahul.cleanarchitecturetestapp.domain.repository

import com.rahul.cleanarchitecturetestapp.data.remote.dto.CoinDetailsDto
import com.rahul.cleanarchitecturetestapp.data.remote.dto.CoinDto

interface CoinRepository {


    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinsById(coinId: String): CoinDetailsDto
}