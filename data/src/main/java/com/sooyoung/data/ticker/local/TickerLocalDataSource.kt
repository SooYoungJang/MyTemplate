package com.sooyoung.data.ticker.local

import com.sooyoung.data.ticker.local.entity.TickerEntity
import kotlinx.coroutines.flow.Flow

interface TickerLocalDataSource {
    suspend fun insertAllTickerEntity(entities: List<TickerEntity>)
    fun getAllTickerEntity(): Flow<List<TickerEntity>>
}