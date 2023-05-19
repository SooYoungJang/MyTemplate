package com.sooyoung.myinittemplate.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sooyoung.core.ui.component.TickerFilterLayer
import com.sooyoung.domain.ticker.model.Ticker
import com.sooyoung.domain.ticker.policy.TickerFilterPolicy
import com.sooyoung.myinittemplate.list.contract.TickerListState
import com.sooyoung.myinittemplate.list.contract.TickerListUiState
import kotlinx.coroutines.flow.Flow

@Composable
fun TickerListRoute(
    vm: TickerListViewModel = hiltViewModel(),
    datas: Flow<List<Ticker>>,
    onClickFilter: (TickerFilterPolicy) -> Unit
) {
    val state by vm.container.stateFlow.collectAsState()

    when (val uiState = state.uiState) {
        TickerListUiState.Error -> {}
        TickerListUiState.Loading -> {}
        is TickerListUiState.Success -> {
//            val datas = uiState.datas.collectAsState(initial = emptyList())
            TickerListScreen(
                state = state,
                datas = datas,
                onClickFilter = onClickFilter
            )
        }
    }
}

@Composable
fun TickerListScreen(
    state: TickerListState,
    datas: Flow<List<Ticker>>,
    onClickFilter: (TickerFilterPolicy) -> Unit
) {
    val list = datas.collectAsState(initial = emptyList())

    Column {
        TickerFilterLayer(onClickFilter = onClickFilter)

        LazyColumn {
            items(list.value.count()) { item ->
                Text(text = "Item ${list.value[item]}")
            }
        }
    }
}