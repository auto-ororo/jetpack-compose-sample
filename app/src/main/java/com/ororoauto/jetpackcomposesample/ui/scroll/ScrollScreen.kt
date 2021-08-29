package com.ororoauto.jetpackcomposesample.ui.scroll

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ororoauto.jetpackcomposesample.ui.Destination
import com.ororoauto.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun ScrollScreen() {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(Destination.Scroll.title) })
        },
        content = {
            Column {
                Column(
                    Modifier
                        // 広げたいComposableにweight設定
                        .weight(1F)
                        .verticalScroll(scrollState)
                ) {
                    Text(
                        "a".repeat(1000), modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Red)
                    )
                    Text(
                        "a".repeat(1000), modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Blue)
                    )
                    Text(
                        "c".repeat(1000), modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Yellow)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    // 固定するComposableにweightを設定しない
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Footer",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleTheme {
        ScrollScreen()
    }
}
