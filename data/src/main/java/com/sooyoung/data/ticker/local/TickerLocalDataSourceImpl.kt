package com.sooyoung.data.ticker.local

import com.sooyoung.data.ticker.local.dao.TickerDao
import com.sooyoung.data.ticker.local.entity.TickerEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TickerLocalDataSourceImpl @Inject constructor(
    private val tickerDao: TickerDao
): TickerLocalDataSource {

    override suspend fun insertAllTickerEntity(entities: List<TickerEntity>) = tickerDao.insertAllTickerEntity(entities)
    override fun getAllTickerEntity(): Flow<List<TickerEntity>> = tickerDao.getAllTickerEntity()
}