package com.sooyoung.myinittemplate

import com.sooyoung.domain.ticker.model.Ticker
import kotlinx.coroutines.flow.Flow

data class KorbitState(
    val uiState: KorbitUiState = KorbitUiState.Loading
)

sealed interface KorbitUiState {
    object Loading : KorbitUiState
    object Error : KorbitUiState
    data class Success(val datas: Flow<List<Ticker>>) : KorbitUiState
}


sealed interface KorbitSideEffect {

}
