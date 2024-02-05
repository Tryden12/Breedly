package com.tryden.breedly.ui.theme


import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColors(
    background = dark_background,
    primary = dark_primary,
    primaryVariant = dark_primary,
    secondary = dark_secondary,
    onSecondary = dark_onSecondary,
    secondaryVariant = dark_secondaryVariant,
    surface = dark_surface,
    onSurface = dark_onSurface
)

private val LightColorScheme = lightColors(
    background = light_background,
    primary = light_primary,
    primaryVariant = light_primary,
    secondary = light_secondary,
    onSecondary = light_onSecondary,
    secondaryVariant = light_secondaryVariant,
    surface = light_surface,
    onSurface = light_onSurface
)

@Composable
fun BreedlyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}