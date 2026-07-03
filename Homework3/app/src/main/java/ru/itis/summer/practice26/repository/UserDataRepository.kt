package ru.itis.summer.practice26.repository

import ru.itis.summer.practice26.model.UserDataModel

object UserDataRepository {

    private val userList = mutableListOf(
        UserDataModel(
            id = "1",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQilI4-yjA-Aa76tDqQAwNYKAri0zhGF50rQFkTAJNisw&s=10",
            userName = "Android 1",
            lastSeen = "1 minute ago",
            description = "Some description to test user profile screen display. Hello android!"
        ),
        UserDataModel(
            id = "2",
            imageUrl = "https://img.magnific.com/free-vector/modern-android-icon_1035-9121.jpg?semt=ais_hybrid&w=740&q=80",
            userName = "Android 2",
        ),
        UserDataModel(
            id = "3",
            imageUrl = "https://static.vecteezy.com/system/resources/previews/021/514/703/non_2x/android-operating-system-logo-icon-symbol-with-name-white-design-software-phone-illustration-with-black-background-free-vector.jpg",
            userName = "Android 3",
            lastSeen = "2 minutes ago",
        ),
        UserDataModel(
            id = "4",
            imageUrl = "https://static.vecteezy.com/system/resources/thumbnails/014/414/701/small_2x/android-logo-on-transparent-background-free-vector.jpg",
            userName = "Android 4",
            lastSeen = "5 minutes ago",
        ),
        UserDataModel(
            id = "5",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQilI4-yjA-Aa76tDqQAwNYKAri0zhGF50rQFkTAJNisw&s=10",
            userName = "Android 5",
            lastSeen = "1 minute ago",
        ),
        UserDataModel(
            id = "6",
            imageUrl = "https://img.magnific.com/free-vector/modern-android-icon_1035-9121.jpg?semt=ais_hybrid&w=740&q=80",
            userName = "Android 6",
        ),
        UserDataModel(
            id = "7",
            imageUrl = "https://static.vecteezy.com/system/resources/previews/021/514/703/non_2x/android-operating-system-logo-icon-symbol-with-name-white-design-software-phone-illustration-with-black-background-free-vector.jpg",
            userName = "Android 7",
            lastSeen = "2 minutes ago",
        ),
        UserDataModel(
            id = "8",
            imageUrl = "https://static.vecteezy.com/system/resources/thumbnails/014/414/701/small_2x/android-logo-on-transparent-background-free-vector.jpg",
            userName = "Android 8",
            lastSeen = "5 minutes ago",
        ),
        UserDataModel(
            id = "9",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQilI4-yjA-Aa76tDqQAwNYKAri0zhGF50rQFkTAJNisw&s=10",
            userName = "Android 10",
            lastSeen = "1 minute ago",
        ),
        UserDataModel(
            id = "10",
            imageUrl = "https://img.magnific.com/free-vector/modern-android-icon_1035-9121.jpg?semt=ais_hybrid&w=740&q=80",
            userName = "Android 11",
        ),
        UserDataModel(
            id = "11",
            imageUrl = "https://static.vecteezy.com/system/resources/previews/021/514/703/non_2x/android-operating-system-logo-icon-symbol-with-name-white-design-software-phone-illustration-with-black-background-free-vector.jpg",
            userName = "Android 12",
            lastSeen = "2 minutes ago",
        ),
        UserDataModel(
            id = "12",
            imageUrl = "https://static.vecteezy.com/system/resources/thumbnails/014/414/701/small_2x/android-logo-on-transparent-background-free-vector.jpg",
            userName = "Android 13",
            lastSeen = "5 minutes ago",
        ),
    )

    fun getUserData() = userList
}