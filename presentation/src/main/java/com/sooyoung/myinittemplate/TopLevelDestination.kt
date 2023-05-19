package com.sooyoung.myinittemplate

enum class TopLevelDestination(val screenRoute: String) {
    TickerList(GraphConst.TickerList),
    TickerFavorites(GraphConst.TickerFavorites)
}

object GraphConst {
    const val TickerList = "ticker_list"
    const val TickerListTitle = "마켓"
    const val TickerFavorites = "ticker_favorites"
    const val TickerFavoritesTitle = "즐겨찾기"
}
