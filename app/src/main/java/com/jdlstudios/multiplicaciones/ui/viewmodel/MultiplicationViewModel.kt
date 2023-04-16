package com.jdlstudios.multiplicaciones.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdlstudios.multiplicaciones.domain.DifficultyLevel
import com.jdlstudios.multiplicaciones.domain.GetMultiplicationUseCase
import com.jdlstudios.multiplicaciones.domain.model.ExerciseDifficulty
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MultiplicationViewModel @Inject constructor(
    private var getMultiplicationUseCase : GetMultiplicationUseCase
): ViewModel() {

    private val _multiplicationModel = MutableLiveData<Multiplication>()
    val multiplicationModel: LiveData<Multiplication>
        get() = _multiplicationModel

    private val _exerciseDifficultyData = MutableLiveData<ExerciseDifficulty>()
    val exerciseDifficultyData: LiveData<ExerciseDifficulty>
        get() = _exerciseDifficultyData

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int>
        get() = _quantity

    init {
        randomMultiplication()
    }

    fun randomMultiplication() {
        val currentMultiplication = getMultiplicationUseCase()
        _multiplicationModel.value = currentMultiplication
    }

    fun checkAnswer(answer: Int): Boolean {
        multiplicationModel.let {
            return _multiplicationModel.value!!.result == answer
        }
    }

    fun reset() {
        randomMultiplication()
    }

    fun setExerciseDifficultyData(difficulty: DifficultyLevel, numExercises: Int) {
        val exerciseDifficulty = ExerciseDifficulty(difficulty, numExercises)
        _exerciseDifficultyData.postValue(exerciseDifficulty)
    }

    fun setQuantity(quantity: Int){
        _quantity.value = quantity
    }

}