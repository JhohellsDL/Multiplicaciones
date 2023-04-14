package com.jdlstudios.multiplicaciones.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.data.model.MultiplicationProvider
import com.jdlstudios.multiplicaciones.domain.GetMultiplicationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MultiplicationViewModel @Inject constructor(
    private var getMultiplicationUseCase : GetMultiplicationUseCase
): ViewModel() {

    private val _multiplicationModel = MutableLiveData<MultiplicationModel>()
    val multiplicationModel: LiveData<MultiplicationModel>
        get() = _multiplicationModel

    private val _stateAnswer = MutableLiveData<Boolean>()
    val stateAnswer: LiveData<Boolean>
        get() = _stateAnswer

    init {
        randomMultiplication()
    }

    fun randomMultiplication() {
        //val currentMultiplication = MultiplicationProvider.randomMultiplication()
        val currentMultiplication = getMultiplicationUseCase()
        _multiplicationModel.value = currentMultiplication
    }

    fun checkAnswer(answer: Int): Boolean {
        multiplicationModel.let {
            if (_multiplicationModel.value!!.result == answer) {
                _stateAnswer.value = true
                return true
            } else {
                _stateAnswer.value = false
                return false
            }
        }
    }

    fun reset() {
        randomMultiplication()
    }


}