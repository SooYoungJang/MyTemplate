package com.sooyoung.myinittemplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberKorbitState(
    navController: NavHostController = rememberNavController(),
): KotbitState {
    return remember(navController) {
        KotbitState(navController)
    }
}

class KotbitState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

//    val currentTopLevelDestination: TopLevelDestination?
//        @Composable get() = when (currentDestination?.route) {
//            tickerListNavigationRoute -> TopLevelDestination.TickerList
//            tickerFavoritesNavigationRoute -> TopLevelDestination.TickerFavorites
//            else -> null
//        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

}