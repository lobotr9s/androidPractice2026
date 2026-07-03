package com.example.homework2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GuessNumber()
                }
            }
        }
    }
}

@Composable
fun GuessNumber() {
    val secretNumber = remember { (0..100).random() }
    var userInput by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("Введите число от 0 до 100") }
    var isGuessed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (isGuessed) {
            AsyncImage(
                model = "https://attachments-cdn-s.coub.com/coub_storage/coub/simple/cw_timeline_pic/b9676995945/70412474cfc8b28d6cdcf/med_1687667861_image.jpg",
                contentDescription = "Победа",
                modifier = Modifier.size(200.dp)
            )
        } else {
            Text(text = text)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = userInput,
            onValueChange = { newInput -> userInput = newInput },
            label = { Text("Ваше число") },
            enabled = !isGuessed
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val number = userInput.toIntOrNull()
                when {
                    number == null -> text = "Введите корректное число"
                    number < 0 || number > 100 -> text = "Число должно быть от 0 до 100"
                    number < secretNumber -> text = "Введенное число меньше загаданного"
                    number > secretNumber -> text = "Введенное число больше загаданного"
                    else -> isGuessed = true
                }
            },
            enabled = !isGuessed
        ) {
            Text("Проверить")
        }
    }
}