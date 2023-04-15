package com.jdlstudios.multiplicaciones.viewmodel

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.domain.GetMultiplicationUseCase
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import com.jdlstudios.multiplicaciones.ui.viewmodel.MultiplicationViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.kotlin.mock
import kotlin.math.absoluteValue

@ExperimentalCoroutinesApi
class MultiplicationViewModelTest {

    @RelaxedMockK
    private lateinit var mockUseCase: GetMultiplicationUseCase

    private lateinit var viewModel: MultiplicationViewModel

    @get:Rule
    var rule = InstantTaskExecutorRule()


    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        viewModel = MultiplicationViewModel(mockUseCase)

        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `randomMultiplication recibe una multiplicacion alatoria`() = runTest {
        //Given
        val multiplication = Multiplication(2,4,8)
        every { mockUseCase.invoke() } returns multiplication

        //When
        viewModel.randomMultiplication()

        //Then
        assert(viewModel.multiplicationModel.value == multiplication)
    }


    @Test
    fun `checkAnswer deberia retornar true si la respuesta es correcta`() = runTest {
        //Given
        val multiplication = Multiplication(2,4,8)
        every { mockUseCase.invoke() } returns multiplication
        val answer = viewModel.multiplicationModel.value!!.result

        //When
        val response = viewModel.checkAnswer(answer)

        //Then
        assertTrue(response)
    }

    @Test
    fun `checkAnswer deberia retornar false si la respuesta es incorrecta`() {

        //Given
        val multiplication = Multiplication(3,5,15)
        every { mockUseCase.invoke() } returns multiplication
        val answer = viewModel.multiplicationModel.value!!.result + 1

        //When
        val response = viewModel.checkAnswer(answer)

        //Then
        assertFalse(response)
    }

}