package com.sooyoung.domain.ticker

import com.sooyoung.domain.ticker.model.Ticker
import kotlinx.coroutines.flow.Flow

interface TickerRepository {
    val tickers: Flow<List<Ticker>>
    suspend fun refreshTicker()
}