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
            val (factorRange1, factorRange2) = difficultyLevels[level] ?: throw IllegalArgumentException("Invalid difficulty level")
            val f1 = factorRange1.random()
            val f2 = factorRange2.random()
            val r = f1 * f2

            return MultiplicationModel(
                factor1 = f1,
                factor2 = f2,
                result = r
            )
        }
        /*private const val MAX_FACTOR_EASY = 9
        private const val MIN_FACTOR_EASY = 0
        private const val MAX_FACTOR2_EASY = 9
        private const val MIN_FACTOR2_EASY = 0

        private const val MAX_FACTOR_INTERMEDIATE = 99
        private const val MIN_FACTOR_INTERMEDIATE = 10
        private const val MAX_FACTOR2_INTERMEDIATE = 9
        private const val MIN_FACTOR2_INTERMEDIATE = 1

        private const val MAX_FACTOR_CHALLENGING = 999
        private const val MIN_FACTOR_CHALLENGING = 100
        private const val MAX_FACTOR2_CHALLENGING = 99
        private const val MIN_FACTOR2_CHALLENGING = 10

        private const val MAX_FACTOR_ADVANCED = 999
        private const val MIN_FACTOR_ADVANCED = 100
        private const val MAX_FACTOR2_ADVANCED = 999
        private const val MIN_FACTOR2_ADVANCED = 100

        fun randomMultiplication(level: DifficultyLevel): MultiplicationModel {
            val (min1, max1) = when (level) {
                DifficultyLevel.EASY -> MIN_FACTOR_EASY to MAX_FACTOR_EASY
                DifficultyLevel.INTERMEDIATE -> MIN_FACTOR_INTERMEDIATE to MAX_FACTOR_INTERMEDIATE
                DifficultyLevel.CHALLENGING -> MIN_FACTOR_CHALLENGING to MAX_FACTOR_CHALLENGING
                DifficultyLevel.ADVANCED -> MIN_FACTOR_ADVANCED to MAX_FACTOR_ADVANCED
            }

            val (min2, max2) = when (level) {
                DifficultyLevel.EASY -> MIN_FACTOR2_EASY to MAX_FACTOR2_EASY
                DifficultyLevel.INTERMEDIATE -> MIN_FACTOR2_INTERMEDIATE to MAX_FACTOR2_INTERMEDIATE
                DifficultyLevel.CHALLENGING -> MIN_FACTOR2_CHALLENGING to MAX_FACTOR2_CHALLENGING
                DifficultyLevel.ADVANCED -> MIN_FACTOR2_ADVANCED to MAX_FACTOR2_ADVANCED
            }

            val f1 = (min1..max1).random()
            val f2 = (min2..max2).random()
            val r = f1 * f2

            return MultiplicationModel(
                factor1 = f1,
                factor2 = f2,
                result = r
            )
        }*/
    }
   /* companion object {
        fun randomMultiplication(level: DifficultyLevel): MultiplicationModel {

            if (level == DifficultyLevel.EASY) {
                val f1 = (0..10).random()
                val f2 = (0..10).random()
                val r = f1 * f2
                return MultiplicationModel(
                    factor1 = f1,
                    factor2 = f2,
                    result = r
                )
            } else if (level == DifficultyLevel.INTERMEDIATE) {
                val f1 = (0..10).random()
                val f2 = (0..10).random()
                val r = f1 * f2
                return MultiplicationModel(
                    factor1 = f1,
                    factor2 = f2,
                    result = r
                )
            } else if (level == DifficultyLevel.CHALLENGING) {
                val f1 = (0..10).random()
                val f2 = (0..10).random()
                val r = f1 * f2
                return MultiplicationModel(
                    factor1 = f1,
                    factor2 = f2,
                    result = r
                )
            } else if (level == DifficultyLevel.ADVANCED) {
                val f1 = (0..10).random()
                val f2 = (0..10).random()
                val r = f1 * f2
                return MultiplicationModel(
                    factor1 = f1,
                    factor2 = f2,
                    result = r
                )
            }

            return MultiplicationModel(
                factor1 = 1,
                factor2 = 1,
                result = 1
            )

        }
    }*/

}