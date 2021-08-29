package com.ororoauto.jetpackcomposesample.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ororoauto.jetpackcomposesample.ui.Destination
import com.ororoauto.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(Destination.Home.title) })
        },
        content = {
            LazyColumn {
                items(Destination.values().filter { it != Destination.Home }) { destination ->
                    NavigateRow(navController = navController, destination = destination)
                }
            }
        }
    )
}

@Composable
fun NavigateRow(navController: NavController, destination: Destination) {
    Row(Modifier.fillMaxWidth().clickable {
        navController.navigate(destination.routeName)
    }) {
        Text(text = destination.title,
            modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleTheme {
        HomeScreen(NavController(LocalContext.current))
    }
}
