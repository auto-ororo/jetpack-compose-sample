package com.ororoauto.jetpackcomposesample.ui.sideeffect

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ororoauto.jetpackcomposesample.ui.Destination
import com.ororoauto.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun SideEffectScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(Destination.Scroll.title) })
        },
        content = {
            val coroutineScope = rememberCoroutineScope()
            var counter by remember { mutableStateOf(0) }
            val list = remember { mutableStateListOf<String>() }

            // keyの変数が変更される度に呼ばれる(Coroutineのキャンセル→発火)
            LaunchedEffect(key1 = counter) {
                list.add(0, "${Date()} LaunchedEffect(key1 = counter) called")
            }

            // keyを定数にすると初回描画時に呼ばれる
            LaunchedEffect(key1 = true) {
                list.add(0, "${Date()} LaunchedEffect(key1 = true) called")
            }

            // 再コンポーズされる度に呼ばれる
            SideEffect {
                list.add(0, "${Date()} SideEffect called")
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    Modifier
                        .fillMaxWidth()
                        .weight(1F)
                        .padding(horizontal = 4.dp)
                    ,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(list) { item ->
                        Text(item)
                    }
                }
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Counter: $counter",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1F)
                            .padding(8.dp)
                    )
                    Button(
                        onClick = { counter += 1 },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text("+1")
                    }
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                delay(1000)
                                counter = 0
                            }
                        },
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text("Reset(by Coroutine)")
                    }
                }

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleTheme {
        SideEffectScreen()
    }
}
