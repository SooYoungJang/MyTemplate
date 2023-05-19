package com.sooyoung.myinittemplate.list.contract

import com.sooyoung.domain.ticker.model.Ticker
import kotlinx.coroutines.flow.Flow

data class TickerListState(
    val uiState: TickerListUiState = TickerListUiState.Loading
)

sealed interface TickerListUiState {
    object Loading : TickerListUiState
    object Error : TickerListUiState
    data class Success(val datas: Flow<List<Ticker>>) : TickerListUiState
}


sealed interface TickerListSideEffect {

}
