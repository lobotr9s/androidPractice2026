package ru.itis.summer.practice26.repository

import ru.itis.summer.practice26.R
import ru.itis.summer.practice26.model.FilmModel

object FilmsRepository {

    private val allFilms = listOf(
        FilmModel(
            id = "1",
            posterResId = R.drawable.marsianin,
            name = "Марсианин",
            releaseDate = 2015
        ),
        FilmModel(
            id = "2",
            posterResId = R.drawable.inter,
            name = "Интерстеллар",
            releaseDate = 2014
        ),
        FilmModel(
            id = "3",
            posterResId = R.drawable.boys,
            name = "Пацаны",
            releaseDate = 2019
        ),
        FilmModel(
            id = "4",
            posterResId = R.drawable.pacific,
            name = "Тихоокеанский рубеж",
            releaseDate = 2013
        ),
    )

    private var filmsList: List<FilmModel> = emptyList()

    fun generateFilms(count: Int) {
        filmsList = allFilms.shuffled().take(count)
    }

    fun getFilms(): List<FilmModel> = filmsList
}