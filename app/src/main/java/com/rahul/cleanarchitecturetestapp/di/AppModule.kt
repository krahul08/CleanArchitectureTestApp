package com.rahul.cleanarchitecturetestapp.di

import com.rahul.cleanarchitecturetestapp.common.Constants
import com.rahul.cleanarchitecturetestapp.data.remote.CoinApi
import com.rahul.cleanarchitecturetestapp.data.repository.CoinRepositoryImpl
import com.rahul.cleanarchitecturetestapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun ProvideCoinRepository(coinApi: CoinApi): CoinRepository {
        return CoinRepositoryImpl(coinApi)
    }

}