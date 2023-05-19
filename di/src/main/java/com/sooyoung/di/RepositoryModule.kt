package com.sooyoung.di

import com.sooyoung.data.ticker.TickerRepositoryImpl
import com.sooyoung.domain.ticker.TickerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsPhotoRepository(
        tickerRepository: TickerRepositoryImpl
    ): TickerRepository

}