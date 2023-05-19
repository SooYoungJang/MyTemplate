package com.sooyoung.myinittemplate.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sooyoung.domain.ticker.model.Ticker
import com.sooyoung.domain.ticker.policy.TickerFilterPolicy
import com.sooyoung.myinittemplate.favorites.TickerFavoritesRoute
import com.sooyoung.myinittemplate.list.TickerListRoute
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TickerTabScreen(
    tabItems: List<TabCategory> = TabCategory.values().toList(),
    datas: Flow<List<Ticker>>,
    onClickFilter: (TickerFilterPolicy) -> Unit
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            tabItems.forEachIndexed { index, item ->
                TickerTabItem(
                    onClick = { scope.launch { pagerState.scrollToPage(index) } },
                    selected = pagerState.currentPage == index,
                    title = item.title,
                )
            }
        }
        HorizontalPager(pageCount = tabItems.size, state = pagerState) { currentPage ->
            when (currentPage) {
                0 -> TickerListRoute(onClickFilter = onClickFilter, datas = datas)
                1 -> TickerFavoritesRoute(onClickFilter = onClickFilter)
            }
        }
    }
}

@Composable
fun TickerTabItem(
    onClick: () -> Unit,
    selected: Boolean,
    title: String,
) {
    val tabHeight = 38.dp
    val bottomPadding = 5.dp
    val selectedColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground

    Tab(selected = selected, onClick = onClick) {
        Column(
            Modifier
                .padding(top = 10.dp, bottom = bottomPadding)
                .height(tabHeight)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = title,
                color = selectedColor
            )
        }
    }
}