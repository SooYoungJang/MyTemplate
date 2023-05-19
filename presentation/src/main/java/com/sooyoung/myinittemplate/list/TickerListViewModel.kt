package com.sooyoung.myinittemplate.list

import androidx.lifecycle.ViewModel
import com.sooyoung.domain.ticker.usecase.GetAllTickerUseCase
import com.sooyoung.domain.ticker.usecase.RefreshTickerUseCase
import com.sooyoung.myinittemplate.list.contract.TickerListSideEffect
import com.sooyoung.myinittemplate.list.contract.TickerListState
import com.sooyoung.myinittemplate.list.contract.TickerListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class TickerListViewModel @Inject constructor(
    private val getAllTickerUseCase: GetAllTickerUseCase,
    private val refreshTickerUseCase: RefreshTickerUseCase,

) : ViewModel(), ContainerHost<TickerListState, TickerListSideEffect> {

    override val container: Container<TickerListState, TickerListSideEffect> = container(initialState = TickerListState()) {
        prepareData()
    }

    private fun prepareData() = intent {
        refreshTickerUseCase.invoke(Unit)
        getTickers()
    }

    private fun getTickers() = intent {
        val tickers = getAllTickerUseCase.invoke(Unit)
        reduce {
            state.copy(TickerListUiState.Success(datas = tickers))
        }
    }

    fun getSortedTickers() = intent {

    }

}