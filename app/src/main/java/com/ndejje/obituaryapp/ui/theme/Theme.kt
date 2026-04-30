package com.ndejje.obituaryapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = APlusBlue,
    secondary = APlusGold,
    background = Color.Black,
    surface = Color.DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = APlusBlue,
    secondary = APlusGold,
    tertiary = APlusGoldDark,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = APlusBlack,
    onBackground = APlusBlack,
    onSurface = APlusBlack
)

@Composable
fun APlusFuneralTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
