package ru.itis.summer.practice26.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.itis.summer.practice26.model.FilmModel
import ru.itis.summer.practice26.repository.FilmsRepository
import ru.itis.summer.practice26.utils.DefaultPaddings
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource


@Composable
fun FilmsListScreen() {
    val allFilms = remember { FilmsRepository.getFilms() }

    var searchInput by remember { mutableStateOf("") }
    var displayedFilms by remember { mutableStateOf(allFilms) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = DefaultPaddings.horizontal, vertical = DefaultPaddings.vertical)
    ) {
        OutlinedTextField(
            value = searchInput,
            onValueChange = { newValue -> searchInput = newValue },
            label = { Text("Год выпуска") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                val yearFilter = searchInput.toIntOrNull()
                displayedFilms = if (yearFilter == null) {
                    allFilms
                } else {
                    allFilms.filter { film -> film.releaseDate <= yearFilter }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сортировать")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (displayedFilms.isEmpty()) {
            Text("Фильмы не найдены")
        } else {
            LazyColumn {
                items(
                    items = displayedFilms,
                    key = { film -> film.id }
                ) { film ->
                    FilmListItem(film = film)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
private fun FilmListItem(film: FilmModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = film.posterResId),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = film.name,
                fontSize = TextUnit(18f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold
            )
            Text(text = film.releaseDate.toString())
        }
    }
}