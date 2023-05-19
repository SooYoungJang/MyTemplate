package com.sooyoung.data.ticker.remote.model

import com.sooyoung.data.ticker.local.entity.TickerEntity

data class Ticker(
    val currencyPair: String,
    val infos: TickerInfo
)

data class TickerInfo(
    val ask: String,
    val bid: String,
    val change: String,
    val changePercent: String,
    val high: String,
    val last: String,
    val low: String,
    val open: String,
    val timestamp: Long,
    val volume: String
)


fun Ticker.asDBEntity(): TickerEntity {
    return TickerEntity(
        currencyPair = this.currencyPair,
        ask = this.infos.ask,
        bid = this.infos.bid,
        change = this.infos.change,
        changePercent = this.infos.changePercent,
        high = this.infos.high,
        last = this.infos.last,
        low = this.infos.low,
        open = this.infos.open,
        timestamp = this.infos.timestamp,
        volume = this.infos.volume,
        isFavorites = false
    )
}