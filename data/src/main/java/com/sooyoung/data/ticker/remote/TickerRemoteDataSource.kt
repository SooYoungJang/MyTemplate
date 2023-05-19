package com.sooyoung.data.ticker.remote

import com.sooyoung.data.ticker.remote.model.Ticker
import kotlinx.coroutines.flow.Flow

interface TickerRemoteDataSource {
   suspend fun getAllTickerDetail(): List<Ticker>
}