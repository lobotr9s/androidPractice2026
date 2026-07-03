package ru.itis.summer.practice26.model

import kotlinx.serialization.Serializable

@Serializable
data class UserDataModel(
    val id: String,
    val imageUrl: String,
    val userName: String,
    val lastSeen: String? = null,
    val description: String? = null,
)
