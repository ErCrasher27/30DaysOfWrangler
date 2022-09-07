package com.example.thirtydaysofwrangler.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = md_theme_dark_primary,
    secondary = md_theme_dark_secondary,

    background = md_theme_dark_background,
    surface = md_theme_dark_surface,
)

private val LightColorPalette = lightColors(
    primary = md_theme_light_primary,
    secondary = md_theme_light_secondary,

    background = md_theme_light_background,
    surface = md_theme_light_surface,
    )

@Composable
fun ThirtyDaysOfWranglerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}