package ru.itis.summer.practice26.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class FilmModel(
    val id: String,
    @DrawableRes val posterResId: Int,
    val name: String,
    val description: String? = null,
    val releaseDate: Int,
)