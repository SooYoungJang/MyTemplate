package com.sooyoung.myinittemplate.favorites

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.sooyoung.core.ui.component.TickerFilterLayer
import com.sooyoung.domain.ticker.policy.TickerFilterPolicy
import com.sooyoung.myinittemplate.favorites.contract.TickerFavoritesUiState

@Composable
fun TickerFavoritesRoute(
    vm: TickerFavoritesViewModel = hiltViewModel(),
    onClickFilter: (TickerFilterPolicy) -> Unit
) {

    val state by vm.container.stateFlow.collectAsState()

    when (val uiState = state.uiState) {
        TickerFavoritesUiState.Error -> {}
        TickerFavoritesUiState.Loading -> {}
        TickerFavoritesUiState.Success -> { TickerFavoritesScreen(onClickFilter = onClickFilter) }
    }
}

@Composable
fun TickerFavoritesScreen(
    onClickFilter: (TickerFilterPolicy) -> Unit
) {
    TickerFilterLayer(onClickFilter = onClickFilter)

    Text(text = "TEST Favorites SCREEN")
}