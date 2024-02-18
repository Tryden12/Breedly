package com.tryden.breedly.ui.theme
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.compose.Blue10
import com.example.compose.Blue20
import com.example.compose.Blue30
import com.example.compose.Blue40
import com.example.compose.Blue80
import com.example.compose.Blue90
import com.example.compose.DarkGreen30
import com.example.compose.DarkGreen90
import com.example.compose.DarkGreenGray10
import com.example.compose.DarkGreenGray20
import com.example.compose.DarkGreenGray90
import com.example.compose.DarkGreenGray95
import com.example.compose.DarkGreenGray99
import com.example.compose.DarkPurpleGray10
import com.example.compose.DarkPurpleGray20
import com.example.compose.DarkPurpleGray90
import com.example.compose.GreenGray50
import com.example.compose.Orange20
import com.example.compose.Orange30
import com.example.compose.Orange80
import com.example.compose.Orange90
import com.example.compose.Pink40
import com.example.compose.Pink90
import com.example.compose.Purple20
import com.example.compose.Purple30
import com.example.compose.Purple80
import com.example.compose.Purple90
import com.example.compose.PurpleGray30
import com.example.compose.PurpleGray60
import com.example.compose.PurpleGray80
import com.example.compose.Red10
import com.example.compose.Red20
import com.example.compose.Red30
import com.example.compose.Red40
import com.example.compose.Red80
import com.example.compose.Red90


private val lightScheme = lightColorScheme(
    primary = DarkPurpleGray20,
    onPrimary = Color.White,
    primaryContainer = DarkGreenGray90,
    onPrimaryContainer = DarkGreenGray10,
    secondary = Blue40,
    onSecondary = Color.White,
    secondaryContainer = Blue90,
    onSecondaryContainer = Blue10,
    tertiary = Pink40,
    onTertiary = Pink90,
    tertiaryContainer = Blue90,
    onTertiaryContainer = DarkGreenGray90,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = DarkGreenGray99,
    onBackground = DarkGreenGray10,
    surface = DarkGreenGray99,
    onSurface = DarkGreenGray10,
    surfaceVariant = DarkGreen90,
    onSurfaceVariant = DarkGreen30,
    inverseSurface = DarkGreenGray20,
    inverseOnSurface = DarkGreenGray95,
    outline = GreenGray50,
    scrim = Pink40
)

private val darkScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = Purple20,
    primaryContainer = Purple30,
    onPrimaryContainer = Purple90,
    secondary = Orange80,
    onSecondary = Orange20,
    secondaryContainer = Orange30,
    onSecondaryContainer = Orange90,
    tertiary = Blue80,
    onTertiary = Blue20,
    tertiaryContainer = Blue30,
    onTertiaryContainer = Blue90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = DarkPurpleGray10,
    onBackground = DarkPurpleGray90,
    surface = DarkPurpleGray10,
    onSurface = DarkPurpleGray90,
    surfaceVariant = PurpleGray30,
    onSurfaceVariant = PurpleGray80,
    inverseSurface = DarkPurpleGray90,
    inverseOnSurface = DarkPurpleGray10,
    outline = PurpleGray60,
    scrim = Pink40
)



@Composable
fun BreedlyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}

