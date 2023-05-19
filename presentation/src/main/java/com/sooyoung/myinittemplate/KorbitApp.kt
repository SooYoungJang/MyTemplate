package com.sooyoung.myinittemplate

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.sooyoung.core.ui.component.TickerFilterLayer
import com.sooyoung.core.ui.component.TickerSearchView
import com.sooyoung.domain.ticker.model.Ticker
import com.sooyoung.domain.ticker.policy.TickerFilterPolicy
import com.sooyoung.myinittemplate.ui.component.TickerTabScreen
import kotlinx.coroutines.flow.Flow

@Composable
fun KorbitApp(
    vm: KorbitViewModel
) {

    val state by vm.container.stateFlow.collectAsState()
    val context = LocalContext.current

    when (val uiState = state.uiState) {
        KorbitUiState.Error -> Toast.makeText(context, "error ...", Toast.LENGTH_SHORT).show()
        KorbitUiState.Loading -> Toast.makeText(context, "loading ...", Toast.LENGTH_SHORT).show()
        is KorbitUiState.Success -> MainScreen(datas = uiState.datas, onClickFilter = vm::getSortedTickers)
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
//    appState: KotbitState = rememberKorbitState(),
    datas: Flow<List<Ticker>>,
    onClickFilter: (TickerFilterPolicy) -> Unit
) {

    Scaffold() { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            Column(Modifier.fillMaxSize()) {
                TickerSearchView("test ", {})
                TickerTabScreen(onClickFilter = onClickFilter, datas = datas)
            }
        }
    }
}
