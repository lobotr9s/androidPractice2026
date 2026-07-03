package ru.itis.summer.practice26.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.itis.summer.practice26.R
import ru.itis.summer.practice26.model.UsersListScreen
import ru.itis.summer.practice26.utils.DefaultPaddings
import ru.itis.summer.practice26.utils.VerificationUtils

@Composable
fun AuthScreen(
    navController: NavController
) {
    var emailFieldValue by remember { mutableStateOf("") }
    var passwordFieldValue by remember { mutableStateOf("") }
    var errorType by remember { mutableStateOf<AuthScreenError?>(null) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = DefaultPaddings.vertical),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            val isEmailError = errorType == AuthScreenError.EMAIL_ERROR

            OutlinedTextField(
                value = emailFieldValue,
                onValueChange = { input: String ->
                    errorType = null
                    emailFieldValue = input
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DefaultPaddings.horizontal),
                isError = isEmailError,
                supportingText = {
                    if (isEmailError) {
                        Text(text = stringResource(R.string.auth_screen_user_email_error))
                    }
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            val isPasswordError = errorType == AuthScreenError.PASSWORD_ERROR

            OutlinedTextField(
                value = passwordFieldValue,
                onValueChange = { input: String ->
                    errorType = null
                    passwordFieldValue = input
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DefaultPaddings.horizontal),
                isError = isPasswordError,
                supportingText = {
                    if (isPasswordError) {
                        Text(text = stringResource(R.string.auth_screen_user_password_error))
                    }
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val isEmailValid = VerificationUtils.isEmailValid(emailFieldValue)
                    val isPasswordValid = VerificationUtils.isPasswordValid(passwordFieldValue)

                    if (isEmailValid && isPasswordValid) {
                        navController.navigate(UsersListScreen)
                    } else {
                        errorType = when {
                            !isEmailValid -> AuthScreenError.EMAIL_ERROR

                            else -> AuthScreenError.PASSWORD_ERROR
                        }


                        // Логика отображения Toast сообщения
//                        val errorTextRes = when {
//                            !isEmailValid -> R.string.auth_screen_user_email_error
//
//                            else -> R.string.auth_screen_user_password_error
//                        }
//                        Toast.makeText(context, errorTextRes, Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DefaultPaddings.horizontal)
            ) {
                Text(text = stringResource(R.string.auth_screen_button))
            }
        }
    }
}

private enum class AuthScreenError {
    EMAIL_ERROR,
    PASSWORD_ERROR,
}