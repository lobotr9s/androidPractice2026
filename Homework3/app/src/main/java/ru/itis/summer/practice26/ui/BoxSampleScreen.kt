package ru.itis.summer.practice26.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxSample() {
    Row {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(start = 16.dp, top = 32.dp)
                .background(Color.Green)
                // .size(200.dp)
                .width(200.dp)
                .height(200.dp)
                .padding(32.dp)
                .background(Color.Red)
                .clickable {
                    println("TEST TAG - Box Clicked")
                }
        )

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
        )
    }
}

@Preview
@Composable
private fun BoxPreview() {
    BoxSample()
}