package com.sooyoung.myinittemplate.favorites.contract

data class TickerFavoritesState(
    val uiState: TickerFavoritesUiState = TickerFavoritesUiState.Loading
)

sealed interface TickerFavoritesUiState {
    object Loading : TickerFavoritesUiState
    object Error : TickerFavoritesUiState
    object Success : TickerFavoritesUiState
}


sealed interface TickerFavoritesSideEffect {

}
