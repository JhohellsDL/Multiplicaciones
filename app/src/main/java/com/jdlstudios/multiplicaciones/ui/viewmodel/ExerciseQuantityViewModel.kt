package com.jdlstudios.multiplicaciones.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdlstudios.multiplicaciones.domain.DifficultyLevel
import com.jdlstudios.multiplicaciones.domain.model.ExerciseDifficulty

class ExerciseQuantityViewModel: ViewModel() {

    private val _exerciseDifficultyData = MutableLiveData<ExerciseDifficulty>()
    val exerciseDifficultyData: LiveData<ExerciseDifficulty>
        get() = _exerciseDifficultyData

    fun setExerciseDifficultyData(difficulty: DifficultyLevel, numExercises: Int = 0) {
        val exerciseDifficulty = ExerciseDifficulty(difficulty, numExercises)
        _exerciseDifficultyData.postValue(exerciseDifficulty)
    }
}
