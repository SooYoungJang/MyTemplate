//package com.sooyoung.myinittemplate.list.navigation
//
//import androidx.navigation.NavController
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavOptions
//import androidx.navigation.compose.composable
//import com.sooyoung.myinittemplate.list.TickerListRoute
//
//
//const val tickerListNavigationRoute = "ticker_list_route"
//
//fun NavController.navigateToTickerList(navOptions: NavOptions? = null) {
//    this.navigate(tickerListNavigationRoute, navOptions)
//}
//
//fun NavGraphBuilder.tickerListScreen() {
//    composable(route = tickerListNavigationRoute) {
//        TickerListRoute()
//    }
//}
//
