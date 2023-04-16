package com.jdlstudios.multiplicaciones.domain

import com.jdlstudios.multiplicaciones.data.repository.MultiplicationRepository
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class GetMultiplicationUseCaseTest{

    @RelaxedMockK
    //private lateinit var multiplicationRepository: MultiplicationRepository
    private val mockRepository = mockk<MultiplicationRepository>()
    private val useCase = GetMultiplicationUseCase(mockRepository)

    //private lateinit var getMultiplicationUseCase: GetMultiplicationUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        //getMultiplicationUseCase = GetMultiplicationUseCase(multiplicationRepository)
    }

    @Test
    fun `checkAnswer with correct answer should return true`(){
        //Given
        val myMultiplication = Multiplication(factor1 = 2, factor2 = 3, result = 6)
        every{ mockRepository.getMultiplicationFromProvider() } returns myMultiplication

        //When
        val response = useCase()

        //Then
        verify(exactly = 1) { mockRepository.getMultiplicationFromProvider() }
        assert(myMultiplication == response)
    }
}