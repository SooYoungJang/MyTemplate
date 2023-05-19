package com.sooyoung.domain.ticker.usecase

import com.sooyoung.domain.base.FlowBaseUseCase
import com.sooyoung.domain.ticker.TickerRepository
import com.sooyoung.domain.ticker.model.Ticker
import javax.inject.Inject

class GetAllTickerUseCase @Inject constructor(
    private val tickerRepository: TickerRepository,
) : FlowBaseUseCase<Unit, List<Ticker>> {

    override suspend fun invoke(param: Unit) = tickerRepository.tickers
}