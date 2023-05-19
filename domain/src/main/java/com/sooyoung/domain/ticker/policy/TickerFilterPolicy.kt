package com.sooyoung.domain.ticker.policy

sealed interface TickerFilterPolicy {

    sealed interface CurrencyPair: TickerFilterPolicy {
        object Desc: CurrencyPair
        object Asc: CurrencyPair
    }

    sealed interface Last: TickerFilterPolicy {
        object Desc: Last
        object Asc: Last
    }

    sealed interface Change: TickerFilterPolicy {
        object Desc: Change
        object Asc: Change
    }

    sealed interface Volume: TickerFilterPolicy {
        object Desc: Volume
        object Asc: Volume
    }

}