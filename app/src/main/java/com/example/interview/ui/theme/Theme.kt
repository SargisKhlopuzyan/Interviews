package com.example.interview.ui.theme

import android.app.Activity
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun InterviewTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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

@Composable
fun KompaktTheme(
    colorScheme: Colors = DarkColors,
    typography: Typography = Typography,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    val activity = view.context as Activity
    if (!view.isInEditMode) {
        SideEffect {
            activity.window.statusBarColor = colorScheme.primary.toArgb()
        }
    }

    MaterialTheme(
        colors = colorScheme,
        typography = typography,
        content = {
            CompositionLocalProvider(
                LocalIndication provides NoRipple,
                content = content,
            )
        }
    )
}

private object NoRipple : Indication, IndicationInstance {
    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource) = this
    override fun ContentDrawScope.drawIndication() = drawContent()
}