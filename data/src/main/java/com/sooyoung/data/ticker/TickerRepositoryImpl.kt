package com.sooyoung.data.ticker

import com.sooyoung.data.ticker.local.TickerLocalDataSource
import com.sooyoung.data.ticker.local.entity.asDomainModel
import com.sooyoung.data.ticker.remote.TickerRemoteDataSource
import com.sooyoung.data.ticker.remote.model.asDBEntity
import com.sooyoung.domain.ticker.TickerRepository
import com.sooyoung.domain.ticker.model.Ticker
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TickerRepositoryImpl @Inject constructor(
    private val remote: TickerRemoteDataSource,
    private val local: TickerLocalDataSource
) : TickerRepository {

    override val tickers: Flow<List<Ticker>> = local.getAllTickerEntity().map { it.asDomainModel() }

    override suspend fun refreshTicker() {
        val tickerList = remote.getAllTickerDetail().map { it.asDBEntity() }
        local.insertAllTickerEntity(tickerList)
    }
}