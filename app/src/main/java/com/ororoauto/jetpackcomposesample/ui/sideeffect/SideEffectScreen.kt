package com.ororoauto.jetpackcomposesample.ui.sideeffect

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ororoauto.jetpackcomposesample.ui.Destination
import com.ororoauto.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import timber.log.Timber

@Composable
fun SideEffectScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(Destination.Scroll.title) })
        },
        content = {
            var counter by remember { mutableStateOf(0) }

            // keyの変数(ほぼStateが指定)が変更される度に呼ばれる(Coroutineのキャンセル→発火)
            LaunchedEffect(key1 = counter) {
                Timber.d("LaunchedEffect(key1 = counter) called")
            }

            // keyを定数にすると初回描画時に呼ばれる
            LaunchedEffect(key1 = true) {
                Timber.d("LaunchedEffect(key1 = true) called")
            }

            // 再コンポーズされる度に呼ばれる
            SideEffect {
                Timber.d("SideEffect called")
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .weight(1F),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        counter.toString(),
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
                Row(Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { counter += 1 },
                        modifier = Modifier
                            .weight(1F)
                            .padding(16.dp)
                    ) {
                        Text("+1")
                    }
                    Button(
                        onClick = { counter -= 1 },
                        modifier = Modifier
                            .weight(1F)
                            .padding(16.dp)
                    ) {
                        Text("-1")
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
