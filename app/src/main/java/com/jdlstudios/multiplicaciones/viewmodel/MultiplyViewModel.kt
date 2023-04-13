package com.jdlstudios.multiplicaciones.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdlstudios.multiplicaciones.model.MultiplicationModel

class MultiplyViewModel : ViewModel() {

    // Use nombres de variables más descriptivos
    private val _numeros = MutableLiveData<MultiplicationModel>()
    val numeros: LiveData<MultiplicationModel>
        get() = _numeros

    private val _answerCorrect = MutableLiveData<Boolean>()
    val answerCorrect: LiveData<Boolean>
        get() = _answerCorrect

    var firstNumber: Int = 0
    var secondNumber: Int = 0

    init {
        generateQuestion()
    }

    fun generateQuestion() {
        // Utilice la función random() de la clase kotlin.random
        firstNumber = (0..10).random()
        secondNumber = (0..10).random()

        // Realice la operación de multiplicación directamente en esta función
        val product = firstNumber * secondNumber

        // Actualice la propiedad _numeros con el resultado
        _numeros.value = MultiplicationModel(firstNumber, secondNumber, product)

        // Establezca _answerCorrect en false
        _answerCorrect.value = false
    }

    fun checkAnswer(answer: Int) {
        // Verifique si la respuesta es correcta
        _answerCorrect.value = answer == firstNumber * secondNumber
    }

    fun reset() {
        generateQuestion()
    }
}