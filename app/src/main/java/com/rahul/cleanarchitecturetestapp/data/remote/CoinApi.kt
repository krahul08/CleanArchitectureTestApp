package com.rahul.cleanarchitecturetestapp.data.remote

import com.rahul.cleanarchitecturetestapp.data.remote.dto.CoinDetailsDto
import com.rahul.cleanarchitecturetestapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetailsById(@Path("coinId") coinId: String): CoinDetailsDto

}