package com.ororoauto.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ororoauto.jetpackcomposesample.ui.AppNavHost
import com.ororoauto.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeSampleTheme {
                AppNavHost()
            }
        }
    }
}