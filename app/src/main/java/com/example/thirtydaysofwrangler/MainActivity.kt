package com.example.thirtydaysofwrangler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysofwrangler.model.wranglers
import com.example.thirtydaysofwrangler.ui.theme.ThirtyDaysOfWranglerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfWranglerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ThirtyDaysOfWranglerApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ThirtyDaysOfWranglerApp() {
    Scaffold(
        topBar = {
            TopBarWranglerApp()
        }
    ) {
        val visibleState = remember {
            MutableTransitionState(false).apply {
                targetState = true
            }
        }
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(
                animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
            ),
            exit = fadeOut()
        ) {

            LazyColumn {
                itemsIndexed(wranglers) { index, wrangler ->
                    WranglerCard(wrangler = wrangler, modifier = Modifier
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = StiffnessVeryLow,
                                    dampingRatio = DampingRatioLowBouncy
                                ),
                                initialOffsetY = { it * (index + 1) } // staggered entrance
                            )
                        ))
                }
            }
        }
    }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun WoofPreview() {
    ThirtyDaysOfWranglerTheme(darkTheme = false) {
        ThirtyDaysOfWranglerApp()
    }
}

/**
 * Composable that displays what ùthe UI of the app looks like in dark theme in the design tab.
 */
@Preview
@Composable
fun WoofDarkThemePreview() {
    ThirtyDaysOfWranglerTheme(darkTheme = true) {
        ThirtyDaysOfWranglerApp()
    }
}