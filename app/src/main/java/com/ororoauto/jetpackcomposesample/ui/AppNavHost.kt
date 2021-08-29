package com.ororoauto.jetpackcomposesample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ororoauto.jetpackcomposesample.ui.counter.CounterScreen
import com.ororoauto.jetpackcomposesample.ui.home.HomeScreen
import com.ororoauto.jetpackcomposesample.ui.scroll.ScrollScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Home.routeName) {
        composable(Destination.Home.routeName) { HomeScreen(navController = navController) }
        composable(Destination.Scroll.routeName) { ScrollScreen() }
        composable(Destination.Counter.routeName) { CounterScreen() }
    }
}

enum class Destination(val routeName: String, val title: String) {
    Home("home", "Home"),
    Scroll("scroll", "Scroll"),
    Counter("counter", "Counter"),
}

