package com.sooyoung.di

import com.sooyoung.data.ticker.local.TickerLocalDataSource
import com.sooyoung.data.ticker.local.TickerLocalDataSourceImpl
import com.sooyoung.data.ticker.remote.TickerRemoteDataSource
import com.sooyoung.data.ticker.remote.TickerRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsPhotoRemoteDataSource(
        tickerRemoteDataSource: TickerRemoteDataSourceImpl
    ): TickerRemoteDataSource

    @Binds
    fun bindsPhotoLocalDataSource(
        tickerLocalDataSource: TickerLocalDataSourceImpl
    ): TickerLocalDataSource

}