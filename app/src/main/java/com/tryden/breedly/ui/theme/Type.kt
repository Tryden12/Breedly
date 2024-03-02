package com.tryden.breedly.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tryden.breedly.R

/**
 * We utilize the "Compose way" of utilizing Google fonts:
 * https://developer.android.com/develop/ui/views/text-and-emoji/downloadable-fonts
 */
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Roboto")

val primaryFontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

val offset = Offset(1f, 1f)


// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        fontFamily = primaryFontFamily
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        fontFamily = primaryFontFamily
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        fontFamily = primaryFontFamily
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        fontFamily = primaryFontFamily
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        letterSpacing = (.5).sp,
        fontSize = 20.sp,
        fontFamily = primaryFontFamily,
        shadow = Shadow(color = Color.Black, offset = offset, blurRadius = 1f)
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        fontFamily = primaryFontFamily
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        fontFamily = primaryFontFamily
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        fontFamily = primaryFontFamily
    ),
    headlineLarge= TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        fontFamily = primaryFontFamily
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        fontFamily = primaryFontFamily
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        fontFamily = primaryFontFamily
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        fontFamily = primaryFontFamily
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        fontFamily = primaryFontFamily
    )

)