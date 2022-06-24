package com.rahul.cleanarchitecturetestapp.domain.use_cases.get_coin

import com.rahul.cleanarchitecturetestapp.common.Resource
import com.rahul.cleanarchitecturetestapp.data.remote.dto.toCoinDetails
import com.rahul.cleanarchitecturetestapp.domain.model.CoinDetails
import com.rahul.cleanarchitecturetestapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(

    private val repository: CoinRepository

) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            /*When api call hits the internet for fetching data*/
            emit(Resource.Loading<CoinDetails>())
            val coin = repository.getCoinsById(coinId).toCoinDetails()

            emit(Resource.Success<CoinDetails>(coin))

        } catch (e: HttpException) {
            emit(
                (Resource.Error<CoinDetails>(
                    e.localizedMessage ?: "An unexpected error occurred"
                ))
            )
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>("Couldn't reach server, Check your internet connection"))

        }


    }

}