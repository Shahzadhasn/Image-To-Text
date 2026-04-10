package com.example.imagetotext.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = TalTeal,
    secondary = TalLightBlue,
    tertiary = TalTeal,
    background = TalWhite
)

@Composable
fun ImageToTextTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
