package com.sooyoung.myinittemplate.ui.component

import com.sooyoung.myinittemplate.GraphConst

enum class TabCategory(val title: String) {
    Market(GraphConst.TickerListTitle),
    Favorites(GraphConst.TickerFavoritesTitle)
}