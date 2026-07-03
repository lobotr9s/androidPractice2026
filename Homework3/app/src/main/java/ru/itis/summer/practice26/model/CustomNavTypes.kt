package ru.itis.summer.practice26.model

import android.net.Uri
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val UserDataModelType = object : NavType<UserDataModel>(isNullableAllowed = true) {

    override fun parseValue(value: String): UserDataModel {
        val userData: UserDataModel = Json.decodeFromString(Uri.decode(value))
        return userData
    }

    override fun serializeAsValue(value: UserDataModel): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(
        bundle: SavedState,
        key: String,
        value: UserDataModel
    ) {
        val userDataString = Json.encodeToString(value)
        bundle.putString(key, userDataString)
    }

    override fun get(
        bundle: SavedState,
        key: String
    ): UserDataModel? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }
}