package com.ororoauto.jetpackcomposesample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ororoauto.jetpackcomposesample.ui.counter.CounterScreen
import com.ororoauto.jetpackcomposesample.ui.home.HomeScreen
import com.ororoauto.jetpackcomposesample.ui.scroll.ScrollScreen
import com.ororoauto.jetpackcomposesample.ui.sideeffect.SideEffectScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Home.routeName) {
        composable(Destination.Home.routeName) { HomeScreen(navController = navController) }
        composable(Destination.Scroll.routeName) { ScrollScreen() }
        composable(Destination.Counter.routeName) { CounterScreen() }
        composable(Destination.SideEffect.routeName) { SideEffectScreen() }
    }
}

enum class Destination(val routeName: String, val title: String) {
    Home("home", "Home"),
    Scroll("scroll", "Scroll"),
    Counter("counter", "Counter"),
    SideEffect("side-effect", "Side Effect"),
}

