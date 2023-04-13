package com.jdlstudios.multiplicaciones.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdlstudios.multiplicaciones.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.model.MultiplicationProvider
import kotlinx.coroutines.*

class MultiplicationViewModel : ViewModel() {

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
        val currentMultiplication = MultiplicationProvider.randomMultiplication()
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