package com.sooyoung.di

import com.sooyoung.data.ticker.local.dao.TickerDao
import com.sooyoung.data.ticker.local.database.KorbitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun providesRecordDao(
        database: KorbitDatabase,
    ): TickerDao = database.tickerDao()

}