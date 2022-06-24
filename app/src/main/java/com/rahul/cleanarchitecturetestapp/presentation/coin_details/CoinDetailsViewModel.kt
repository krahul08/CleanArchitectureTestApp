package com.rahul.cleanarchitecturetestapp.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.cleanarchitecturetestapp.common.Constants
import com.rahul.cleanarchitecturetestapp.common.Resource
import com.rahul.cleanarchitecturetestapp.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel

/*To keep the state*/
class CoinDetailsViewModel @Inject constructor(

    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {

        /*Because we already invoke operator function*/
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinDetailsState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}