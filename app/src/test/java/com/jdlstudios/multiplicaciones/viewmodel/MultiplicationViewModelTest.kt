package com.jdlstudios.multiplicaciones.viewmodel

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.ui.viewmodel.MultiplicationViewModel
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import kotlin.math.absoluteValue

class MultiplicationViewModelTest {/*

    // Regla que especifica que las tareas se ejecutan en el hilo principal de la prueba
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MultiplicationViewModel

    private val mockMultiplicationModel = Mockito.spy(MutableLiveData<MultiplicationModel>())

    @Before
    fun setUp() {
        //viewModel = MultiplicationViewModel()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `checkAnswer with correct answer should return true`() {
       *//* // Given

        val currentMultiplication = viewModel._multiplicationModel.value?.result
        val answer = currentMultiplication
        val observer = Observer<MultiplicationModel>{
            assertEquals(answer,it.result)
        }
        mockMultiplicationModel.observeForever(observer)

        // When
        val result = answer?.let { viewModel.checkAnswer(it) }

        // Then
        assertEquals(false, result)
        assertEquals(false, viewModel.stateAnswer.value)*//*
    }

    @Test
    fun randomMultiplication() {

        viewModel.randomMultiplication()

        val multiplicationModel = viewModel.multiplicationModel.value

        assert(multiplicationModel != null)

    }

    @Test
    fun getMultiplicationModel() {

    }

    @Test
    fun checkAnswer() {
        viewModel.randomMultiplication()

        val multiplyViewModelTest = viewModel.multiplicationModel
        val state = viewModel.stateAnswer.value
        val f1 = multiplyViewModelTest.value!!.factor1
        val f2 = multiplyViewModelTest.value!!.factor2

        *//*viewModel.checkAnswer(f1*f2+1)
        assertNotEquals(state, false)*//*

        viewModel.checkAnswer(f1*f2)
        assertEquals(state, true)
    }

    @Test
    fun reset() {
        viewModel = Mockito.spy(viewModel)
        viewModel.reset()

        Mockito.verify(viewModel).randomMultiplication()
    }*/
}