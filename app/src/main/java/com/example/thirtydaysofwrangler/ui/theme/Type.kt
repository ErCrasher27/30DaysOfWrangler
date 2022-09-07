package com.example.thirtydaysofwrangler.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydaysofwrangler.R

val Raleway = FontFamily(
    Font(R.font.raleway_bold, FontWeight.Bold),
    Font(R.font.raleway_regular, FontWeight.Normal),
    Font(R.font.raleway_thin, FontWeight.Thin)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Raleway,
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 35.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Thin,
        fontSize = 32.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Thin,
        fontSize = 18.sp
    )
)