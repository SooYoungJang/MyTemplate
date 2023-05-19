//package com.sooyoung.myinittemplate
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import com.sooyoung.myinittemplate.favorites.navigation.tickerFavoritesScreen
//import com.sooyoung.myinittemplate.list.navigation.tickerListNavigationRoute
//import com.sooyoung.myinittemplate.list.navigation.tickerListScreen
//
//@Composable
//fun KorbitNavHost(
//    navController: NavHostController,
//    modifier: Modifier = Modifier,
//    startDestination: String = tickerListNavigationRoute,
//) {
//    NavHost(
//    navController = navController,
//    startDestination = startDestination,
//    modifier = modifier
//    ) {
//        tickerListScreen()
//        tickerFavoritesScreen()
//    }
//}