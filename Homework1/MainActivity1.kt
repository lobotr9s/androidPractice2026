package com.example.myfirstprogramm

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity1 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        analyzeIntList(listOf(67, -14, 22, -8, 15))

        println("TEST TAG - ${passwordProtect("someTestPassword")}")
    }
}


fun analyzeIntList(input: List<Int>) {
    var minNumber: Int
    var maxNumber: Int
    var sumAllNumber: Int
    var cntEvenNumber = 0
    var cntOddNumber = 0

    maxNumber = input.max()
    minNumber = input.min()
    sumAllNumber = input.sum()

    for (i in input) {
        if (i % 2 == 0) {
            cntEvenNumber += 1
        } else {
            cntOddNumber += 1
        }
    }

    println("TEST TAG - Минимальное: $minNumber")
    println("TEST TAG - Максимальное: $maxNumber")
    println("TEST TAG - Сумма: $sumAllNumber")
    println("TEST TAG - Четных: $cntEvenNumber")
    println("TEST TAG - Нечетных: $cntOddNumber")
}

fun passwordProtect(input: String) : String {
    var cnt = 0

    if (input.length >= 8) {
        cnt++
    }

    if (input.any { it.isDigit() }) {
        cnt++;
    }

    if (input.any { it.isUpperCase() }) {
        cnt++
    }

    if (input.any { it.isLowerCase() }) {
        cnt++
    }

    if (input.any { !it.isLetterOrDigit()}) {
        cnt++
    }

    return when (cnt) {
        5 -> "Надёжность пароля: надежный пароль"
        4 -> "Надёжность пароля: хороший пароль"
        2, 3 -> "Надёжность пароля: средний пароль"
        else -> "Надёжность пароля: ненадежный пароль"
    }
}


