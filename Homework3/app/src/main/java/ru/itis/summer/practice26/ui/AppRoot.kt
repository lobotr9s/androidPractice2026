package ru.itis.summer.practice26.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ru.itis.summer.practice26.model.AuthScreen
import ru.itis.summer.practice26.model.UserDataModel
import ru.itis.summer.practice26.model.UserDataModelType
import ru.itis.summer.practice26.model.UserProfileScreen
import ru.itis.summer.practice26.model.UsersListScreen
import ru.itis.summer.practice26.repository.UserDataRepository
import kotlin.reflect.typeOf
import ru.itis.summer.practice26.model.GenerateFilmsScreen
import ru.itis.summer.practice26.model.FilmsListScreen

@Composable
fun AppRoot(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = GenerateFilmsScreen,
    ) {
        composable<AuthScreen> {
            AuthScreen(navController = navHostController)
        }

        composable<UsersListScreen> {
            UsersLazyColumnSample(
                usersData = UserDataRepository.getUserData(),
                navController = navHostController
            )
        }

        composable<GenerateFilmsScreen> {
            GenerateFilmsScreen(navController = navHostController)
        }

        composable<FilmsListScreen> {
            FilmsListScreen()
        }

        composable<UserProfileScreen>(
            typeMap = mapOf(typeOf<UserDataModel>() to UserDataModelType)
        ) { entry ->
            val route = entry.toRoute<UserProfileScreen>()

            UserProfileContent(userDataModel = route.userDataModel)
        }
    }
}