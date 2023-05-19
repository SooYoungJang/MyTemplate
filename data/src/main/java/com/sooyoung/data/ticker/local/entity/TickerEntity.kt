package com.sooyoung.data.ticker.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sooyoung.domain.ticker.model.Ticker

@Entity
data class TickerEntity(
    @PrimaryKey
    val currencyPair: String,
    val ask: String,
    val bid: String,
    val change: String,
    val changePercent: String,
    val high: String,
    val last: String,
    val low: String,
    val open: String,
    val timestamp: Long,
    val volume: String,
    val isFavorites: Boolean
)

fun List<TickerEntity>.asDomainModel(): List<Ticker> {
    return map {
        Ticker(
            currencyPair = it.currencyPair,
            ask = it.ask,
            bid = it.bid,
            change = it.change,
            changePercent = it.changePercent,
            high = it.high,
            last = it.last,
            low = it.low,
            open = it.open,
            timestamp = it.timestamp,
            volume = it.volume,
            isFavorites = it.isFavorites
        )
    }
}