package com.taghavi.glassbottomnavigationjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.taghavi.glassbottomnavigationjetpackcompose.ui.theme.GlassBottomNavigationJetpackComposeTheme
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlassBottomNavigationJetpackComposeTheme {
                val hazeState = remember { HazeState() }
                Scaffold(
                    bottomBar = { GlassBottomNavigation(hazeState) }
                ) { padding ->
                    LazyColumn(
                        Modifier
                            .haze(
                                hazeState,
                                backgroundColor = MaterialTheme.colorScheme.background,
                                tint = Color.Black.copy(alpha = 0.2f),
                                blurRadius = 30.dp,
                            )
                            .fillMaxSize()
                            .background(Color.Gray),
                        contentPadding = padding,
                    ) {
                        items(50) {
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .background(Color.DarkGray, RoundedCornerShape(12.dp))
                                    .border(
                                        width = Dp.Hairline,
                                        color = Color.White.copy(alpha = 0.5f),
                                        shape = RoundedCornerShape(12.dp),
                                    )
                                    .clip(RoundedCornerShape(12.dp))
                            ) {
                                AsyncImage(
                                    model = "https://source.unsplash.com/random?neon,$it",
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
