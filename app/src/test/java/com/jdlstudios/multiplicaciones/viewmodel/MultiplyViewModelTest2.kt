package com.jdlstudios.multiplicaciones.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MultiplyViewModelTest2{

    // Regla que especifica que las tareas se ejecutan en el hilo principal de la prueba
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    // Creamos un objeto de tipo MultiplyViewModel para utilizarlo en las pruebas
    private lateinit var viewModel: MultiplyViewModel

    // Creamos los valores mock que utilizaremos en las pruebas
    private val mockNum1 = MutableLiveData<Int>()
    private val mockNum2 = MutableLiveData<Int>()
    private val mockAnswerCorrect = MutableLiveData<Boolean>()

    // Función que se ejecuta antes de cada prueba, se utiliza para inicializar el objeto de tipo MultiplyViewModel
    @Before
    fun setup() {
        viewModel = MultiplyViewModel()
    }

    // Prueba que verifica que se genere una nueva pregunta correctamente
    @Test
    fun generateQuestion() {
        // Llamamos a la función que genera la nueva pregunta
        viewModel.generateQuestion()

        // Obtenemos los valores generados por la función
        val numeros = viewModel.numeros.value
        val n1 = viewModel.firstNumber
        val n2 = viewModel.secondNumber

        // Verificamos que los valores no sean nulos
        assert(numeros != null)

        // Verificamos que los valores generados sean correctos
        assertEquals(numeros!!.factor1, n1)
        assertEquals(numeros.factor2, n2)
        assertEquals(numeros.product, n1 * n2)
    }

    // Prueba que verifica que se verifique la respuesta correctamente
    @Test
    fun checkAnswer() {
        // Generamos una nueva pregunta
        viewModel.generateQuestion()

        // Obtenemos los valores de los números generados
        val n1 = viewModel.firstNumber
        val n2 = viewModel.secondNumber

        // Verificamos una respuesta incorrecta
        viewModel.checkAnswer(n1 * n2 + 1)
        assertEquals(viewModel.answerCorrect.value, false)

        // Verificamos una respuesta correcta
        viewModel.checkAnswer(n1 * n2)
        assertEquals(viewModel.answerCorrect.value, true)
    }

    // Prueba que verifica que se resetee correctamente la pregunta
    @Test
    fun reset() {
        // Mockeamos la función generateQuestion
        viewModel = Mockito.spy(viewModel)
        viewModel.reset()

        // Verificamos que se haya llamado la función generateQuestion
        Mockito.verify(viewModel).generateQuestion()

        // Verificamos que los valores mock sean correctos después de resetear
        //assertEquals(viewModel.numeros.value, null)
        assertEquals(viewModel.answerCorrect.value, false)
    }

}