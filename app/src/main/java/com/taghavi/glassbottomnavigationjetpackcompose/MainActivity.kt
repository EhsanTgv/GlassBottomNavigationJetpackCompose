package com.taghavi.glassbottomnavigationjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.taghavi.glassbottomnavigationjetpackcompose.ui.theme.GlassBottomNavigationJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlassBottomNavigationJetpackComposeTheme {

            }
        }
    }
}
