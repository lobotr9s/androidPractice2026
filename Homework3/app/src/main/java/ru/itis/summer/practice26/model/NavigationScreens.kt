package ru.itis.summer.practice26.model

import kotlinx.serialization.Serializable

@Serializable
object AuthScreen

@Serializable
object UsersListScreen

@Serializable
data class UserProfileScreen(
    val userDataModel: UserDataModel
)

@Serializable
object GenerateFilmsScreen

@Serializable
object FilmsListScreen
