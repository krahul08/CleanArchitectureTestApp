package com.rahul.cleanarchitecturetestapp.data.repository

import com.rahul.cleanarchitecturetestapp.data.remote.CoinApi
import com.rahul.cleanarchitecturetestapp.data.remote.dto.CoinDetailsDto
import com.rahul.cleanarchitecturetestapp.data.remote.dto.CoinDto
import com.rahul.cleanarchitecturetestapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(

    private val api: CoinApi

) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailsDto {
        return api.getCoinDetailsById(coinId = coinId)
    }
}