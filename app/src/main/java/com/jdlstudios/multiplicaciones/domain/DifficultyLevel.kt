package com.jdlstudios.multiplicaciones.domain

import java.util.Locale

enum class DifficultyLevel {
    EASY,
    INTERMEDIATE,
    CHALLENGING,
    ADVANCED;

    companion object {
        fun getDifficultyLevelFromName(name: String): DifficultyLevel {
            return when (name.uppercase(Locale.ROOT)) {
                "EASY" -> EASY
                "INTERMEDIATE" -> INTERMEDIATE
                "CHALLENGING" -> CHALLENGING
                "ADVANCED" -> ADVANCED
                else -> throw IllegalArgumentException("Invalid difficulty level name")
            }
        }
    }
}