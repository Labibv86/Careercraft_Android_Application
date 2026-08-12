package com.example.careercraft.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.OutlinedTextFieldDefaults

private val CareerCraftColors = lightColorScheme(
    primary = DeepGrey,
    onPrimary = White,
    secondary = LightGrey,
    onSecondary = Black,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    error = Red,
    onError = White
)

@Composable
fun CareerCraftTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CareerCraftColors,
        typography = CareerCraftTypography,
        content = content
    )
}


@Composable
fun careerCraftTextFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = Black,
    unfocusedBorderColor = MidGrey,
    focusedLabelColor = Black,
    unfocusedLabelColor = Grey,
    cursorColor = Black
)