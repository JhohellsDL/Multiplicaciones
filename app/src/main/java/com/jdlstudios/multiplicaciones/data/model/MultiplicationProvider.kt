package com.jdlstudios.multiplicaciones.data.model

import com.jdlstudios.multiplicaciones.domain.DifficultyLevel

class MultiplicationProvider {

    companion object {

        private val difficultyLevels = mapOf(
            DifficultyLevel.EASY to Pair(0..9, 0..9),
            DifficultyLevel.INTERMEDIATE to Pair(10..99, 1..9),
            DifficultyLevel.CHALLENGING to Pair(100..999, 10..99),
            DifficultyLevel.ADVANCED to Pair(100..999, 100..999)
        )

        fun randomMultiplication(level: DifficultyLevel): MultiplicationModel {
            val (factorRange1, factorRange2) = difficultyLevels[level]
                ?: throw IllegalArgumentException("Invalid difficulty level")
            val f1 = factorRange1.random()
            val f2 = factorRange2.random()
            val r = f1 * f2

            return MultiplicationModel(
                factor1 = f1,
                factor2 = f2,
                result = r
            )
        }
    }
}