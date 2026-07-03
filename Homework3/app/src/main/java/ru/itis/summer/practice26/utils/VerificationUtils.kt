package ru.itis.summer.practice26.utils

import android.util.Patterns

object VerificationUtils {

    fun isEmailValid(input: String): Boolean {
        val emailRegex = Patterns.EMAIL_ADDRESS
        return emailRegex.matcher(input).matches()
    }

    fun isPasswordValid(input: String): Boolean {
        return input.length >= 8
                && input.contains("[A-Z]".toRegex())
                && input.contains("[a-z]".toRegex())
    }
}