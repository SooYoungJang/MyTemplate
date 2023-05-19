package com.sooyoung.myinittemplate.favorites

import androidx.lifecycle.ViewModel
import com.sooyoung.domain.ticker.usecase.GetAllTickerUseCase
import com.sooyoung.myinittemplate.favorites.contract.TickerFavoritesSideEffect
import com.sooyoung.myinittemplate.favorites.contract.TickerFavoritesState
import com.sooyoung.myinittemplate.favorites.contract.TickerFavoritesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class TickerFavoritesViewModel @Inject constructor(
    getAllTickerUseCase: GetAllTickerUseCase
): ViewModel(), ContainerHost<TickerFavoritesState, TickerFavoritesSideEffect> {

    override val container: Container<TickerFavoritesState, TickerFavoritesSideEffect> = container(initialState = TickerFavoritesState()) {
        prepareData()
    }

    private fun prepareData() = intent {
        reduce {
            state.copy(TickerFavoritesUiState.Success)
        }
    }
}