package com.sooyoung.data.ticker.remote

import com.sooyoung.data.ticker.remote.model.Ticker
import com.sooyoung.data.ticker.remote.model.TickerInfo
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TickerRemoteDataSourceImpl @Inject constructor(
    private val tickerApi: TickerApi
) : TickerRemoteDataSource {
    override suspend fun getAllTickerDetail(): List<Ticker> {
        return tickerApi.getAllTickerDetail()
            .map { entry ->
                val symbol = entry.key
                val value = entry.value
                Ticker(
                    currencyPair = symbol,
                    infos = TickerInfo(
                        ask = value.ask,
                        bid = value.bid,
                        change = value.change,
                        changePercent = value.changePercent,
                        high = value.high,
                        last = value.last,
                        low = value.low,
                        open = value.open,
                        timestamp = value.timestamp,
                        volume = value.volume
                    )
                )
            }
    }
}