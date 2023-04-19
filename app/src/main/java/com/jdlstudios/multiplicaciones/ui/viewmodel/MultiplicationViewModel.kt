package com.jdlstudios.multiplicaciones.ui.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationEntity
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationSessionEntity
import com.jdlstudios.multiplicaciones.domain.DifficultyLevel
import com.jdlstudios.multiplicaciones.domain.usescases.GetMultiplicationUseCase
import com.jdlstudios.multiplicaciones.domain.model.ExerciseDifficulty
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import com.jdlstudios.multiplicaciones.domain.usescases.GetSessionUseCase
import com.jdlstudios.multiplicaciones.domain.usescases.InsertSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class MultiplicationViewModel @Inject constructor(
    private var getMultiplicationUseCase: GetMultiplicationUseCase,
    private var getSessionUseCase: GetSessionUseCase,
    private var insertSessionUseCase: InsertSessionUseCase
) : ViewModel() {

    private val _multiplicationModel = MutableLiveData<Multiplication>()
    val multiplicationModel: LiveData<Multiplication>
        get() = _multiplicationModel

    private val _exerciseDifficultyData = MutableLiveData<ExerciseDifficulty>()
    val exerciseDifficultyData: LiveData<ExerciseDifficulty>
        get() = _exerciseDifficultyData

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int>
        get() = _quantity

    private val _level = MutableLiveData<DifficultyLevel>()
    val level: LiveData<DifficultyLevel>
        get() = _level

    //-----------------------------------para coroutinas------------------------------------------------
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    //--------------------------------------------------------------------------------------------------

    init {
        level.observeForever { value ->
            if (value != null) {
                randomMultiplication(value)
                sessionInit()
            }
        }

    }

    fun randomMultiplication(difficulty: DifficultyLevel = level.value ?: DifficultyLevel.EASY) {
        val currentMultiplication = getMultiplicationUseCase(difficulty)
        _multiplicationModel.value = currentMultiplication
    }

    val session1: MultiplicationSessionEntity = MultiplicationSessionEntity(
        level = DifficultyLevel.CHALLENGING,
        date = LocalDate.now(),
        correct = 7,
        incorrect = 3,
        wrongList = listOf(Multiplication(1, 2, 3)),
        correctList = listOf(Multiplication(1, 2, 3))
    )

    val session2: MultiplicationSessionEntity = MultiplicationSessionEntity(
        level = DifficultyLevel.CHALLENGING,
        date = LocalDate.now(),
        correct = 17,
        incorrect = 13,
        wrongList = listOf(Multiplication(1, 2, 3)),
        correctList = listOf(Multiplication(1, 2, 3))
    )

    private fun sessionInit() {
        viewModelScope.launch {
            insertSessionUseCase(session1)
            insertSessionUseCase(session2)
            val sess = getListSession().size
            val sess10 = getSession()
            Log.i("sum", "sess : $sess --$sess10")
        }
    }

    private suspend fun getListSession(): List<MultiplicationSessionEntity> {
        return getSessionUseCase.getList()
    }

    private suspend fun getSession(): MultiplicationSessionEntity {
        return getSessionUseCase.getSessionWithID(10L)
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

    fun setQuantity(quantity: Int) {
        _quantity.value = quantity
    }

    fun setDifficulty(level: DifficultyLevel) {
        _level.value = level
    }

}