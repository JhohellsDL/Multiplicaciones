package com.jdlstudios.multiplicaciones.domain.model

import android.os.Parcelable
import com.jdlstudios.multiplicaciones.domain.DifficultyLevel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseDifficulty(
    val difficulty: DifficultyLevel,
    val exerciseCount: Int
) : Parcelable
