package com.sooyoung.domain.ticker.usecase

import com.sooyoung.domain.base.FlowBaseUseCase
import com.sooyoung.domain.ticker.TickerRepository
import com.sooyoung.domain.ticker.model.Ticker
import com.sooyoung.domain.ticker.policy.TickerFilterPolicy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSortedTickerUseCase @Inject constructor(
    private val tickerRepository: TickerRepository,
) : FlowBaseUseCase<TickerFilterPolicy, List<Ticker>> {

    override suspend fun invoke(param: TickerFilterPolicy): Flow<List<Ticker>> {
        return tickerRepository.tickers.map { tickers ->
            when (param) {
                TickerFilterPolicy.Change.Asc -> tickers.sortedBy { it.change }
                TickerFilterPolicy.Change.Desc -> tickers.sortedByDescending { it.change }
                TickerFilterPolicy.CurrencyPair.Asc -> tickers.sortedBy { it.currencyPair }
                TickerFilterPolicy.CurrencyPair.Desc -> tickers.sortedByDescending { it.currencyPair }
                TickerFilterPolicy.Last.Asc -> tickers.sortedBy { it.last }
                TickerFilterPolicy.Last.Desc -> tickers.sortedByDescending { it.last }
                TickerFilterPolicy.Volume.Asc -> tickers.sortedBy { it.volume }
                TickerFilterPolicy.Volume.Desc -> tickers.sortedByDescending { it.volume }
            }
        }
    }

}