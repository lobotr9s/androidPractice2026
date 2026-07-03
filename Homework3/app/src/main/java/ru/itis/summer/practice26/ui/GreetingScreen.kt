package ru.itis.summer.practice26.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Greetings() {
    Text(
        text = "Hello World!",
        fontSize = TextUnit(24f, TextUnitType.Sp),
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .padding(start = 16.dp, top = 32.dp)
    )
}