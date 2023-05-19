package com.sooyoung.domain.ticker.usecase

import android.util.Log
import com.sooyoung.domain.base.BaseUseCase
import com.sooyoung.domain.ticker.TickerRepository
import javax.inject.Inject

class RefreshTickerUseCase @Inject constructor(
    private val tickerRepository: TickerRepository
) : BaseUseCase<Unit, Unit> {
    override suspend fun invoke(param: Unit) {
        try {
            tickerRepository.refreshTicker()
        }catch (e: Exception) {
            Log.d("test","eddt test $e")
        }
    }
}