package com.sooyoung.myinittemplate

import androidx.lifecycle.ViewModel
import com.sooyoung.domain.ticker.policy.TickerFilterPolicy
import com.sooyoung.domain.ticker.usecase.GetAllTickerUseCase
import com.sooyoung.domain.ticker.usecase.GetSortedTickerUseCase
import com.sooyoung.domain.ticker.usecase.RefreshTickerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class KorbitViewModel @Inject constructor(
    private val refreshTickerUseCase: RefreshTickerUseCase,
    private val getAllTickerUseCase: GetAllTickerUseCase,
    private val getSortedTickerUseCase: GetSortedTickerUseCase
) : ViewModel(), ContainerHost<KorbitState, KorbitSideEffect> {
    override val container: Container<KorbitState, KorbitSideEffect> = container(initialState = KorbitState()) {
        prepareData()
    }

    private fun prepareData() = intent {
        refreshTickerUseCase.invoke(Unit)
        val datas = getAllTickerUseCase.invoke(Unit)

        reduce {
            state.copy(
                uiState = KorbitUiState.Success(
                    datas = datas
                )
            )
        }
    }

    fun getSortedTickers(filter: TickerFilterPolicy) = intent {
        val datas = getSortedTickerUseCase.invoke(filter)
        reduce {
            state.copy(
                uiState = KorbitUiState.Success(
                    datas = datas
                )
            )
        }
    }

}